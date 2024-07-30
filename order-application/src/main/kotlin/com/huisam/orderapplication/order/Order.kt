package com.huisam.orderapplication.order

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.ZonedDateTime

@Entity
@Table(name = "orders")
class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "product_id", nullable = false, updatable = false)
    val productId: Long,

    @Column(name = "order_date", nullable = false, updatable = false)
    val orderDate: ZonedDateTime,

    @Column(name = "total_amount", nullable = false)
    val totalAmount: BigDecimal
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Order) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int = id.hashCode()

    override fun toString(): String = "Order(id=$id)"
}