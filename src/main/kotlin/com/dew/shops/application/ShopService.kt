package com.dew.shops.application

import com.dew.shops.application.create.CreateShopCommand
import com.dew.shops.domain.Shop
import com.dew.shops.domain.ShopRepository
import jakarta.inject.Singleton
import reactor.core.publisher.Mono

@Singleton
class ShopService(private val repository: ShopRepository) {

    fun save(command: CreateShopCommand): Mono<Boolean> {
        val shop = Shop(
            command.name,
            command.nit,
            command.address,
            command.phone,
            command.userId,
            command.email
        )
        
        return repository.save(shop)
    }
}