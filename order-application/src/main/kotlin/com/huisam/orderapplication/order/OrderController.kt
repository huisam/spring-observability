package com.huisam.orderapplication.order

import com.huisam.orderapplication.product.ProductClient
import io.micrometer.observation.annotation.Observed
import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.time.ZonedDateTime

@RestController
@RequestMapping("/api/v1/orders")
class OrderController(
    private val orderRepository: OrderRepository,
    private val productClient: ProductClient,
) {
    private val logger = LoggerFactory.getLogger(OrderController::class.java)

    @GetMapping("/{id}")
    fun getOrder(@PathVariable id: Long): ResponseEntity<Order> {
        logger.info("Get order requested by id $id")

        val order = orderRepository.findByIdOrNull(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

        return ResponseEntity.ok(order)
    }

    @Observed(name = "order.place")
    @PostMapping("/place-order")
    fun placeOrder(@RequestBody @Valid request: PlaceOrderRequest): ResponseEntity<Order> {
        logger.info("Place order requested by id ${request.productId}")

        val product = productClient.getProduct(request.productId!!)
        val order = orderRepository.save(
            Order(productId = product.id, orderDate = ZonedDateTime.now(), totalAmount = product.amount)
        )

        return ResponseEntity.ok(order)
    }
}