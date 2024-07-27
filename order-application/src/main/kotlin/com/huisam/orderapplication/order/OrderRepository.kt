package com.huisam.orderapplication.order

import org.springframework.data.repository.CrudRepository

interface OrderRepository : CrudRepository<Order, Long>