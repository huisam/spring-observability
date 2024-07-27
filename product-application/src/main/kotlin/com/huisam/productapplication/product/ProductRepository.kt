package com.huisam.productapplication.product

import org.springframework.data.repository.CrudRepository

interface ProductRepository : CrudRepository<Product, Long>