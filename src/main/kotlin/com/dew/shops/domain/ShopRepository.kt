package com.dew.shops.domain

import reactor.core.publisher.Mono
import javax.validation.Valid

interface ShopRepository {

    fun save(@Valid shop: Shop): Mono<Boolean>

    fun findById(id: String): Mono<Shop>
    fun findByUserId(userId: String): Mono<Shop>
}