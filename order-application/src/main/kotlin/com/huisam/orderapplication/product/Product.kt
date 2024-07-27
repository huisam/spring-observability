package com.huisam.orderapplication.product

import java.math.BigDecimal

data class Product(
    val id: Long,
    val amount: BigDecimal,
    val name: String,
)