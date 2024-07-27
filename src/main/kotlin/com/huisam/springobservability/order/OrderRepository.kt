package com.huisam.springobservability.order

import org.springframework.data.repository.CrudRepository

interface OrderRepository : CrudRepository<Order, Long>