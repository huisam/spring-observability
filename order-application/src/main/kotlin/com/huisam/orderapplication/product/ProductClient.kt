package com.huisam.orderapplication.product

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "product-service", url = "http://product-application:8080")
interface ProductClient {
    @GetMapping(value = ["/api/v1/products/{id}"])
    fun getProduct(@PathVariable id: Long): Product
}