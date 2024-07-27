package com.huisam.orderapplication.order

import org.jetbrains.annotations.NotNull

data class PlaceOrderRequest(
    @get:NotNull
    val productId: Long?
)