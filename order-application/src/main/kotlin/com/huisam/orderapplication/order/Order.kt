package com.huisam.orderapplication.order

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.ZonedDateTime

@Entity
@Table(name = "orders")
class Order(
    @Id
    val id: Long,

    @Column(name = "product_id")
    val productId: Long,

    @Column(name = "order_date")
    val orderDate: ZonedDateTime,

    @Column(name = "total_amount")
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