package com.huisam.productapplication.product

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(name = "product")
class Product(
    @Id
    val id: Long,

    @Column(name = "amount", nullable = false)
    val amount: BigDecimal,

    @Column(name = "name", nullable = false)
    val name: String,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Product) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int = id.hashCode()

    override fun toString(): String = "Product(id=$id)"
}