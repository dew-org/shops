package com.dew.shops.application.create

import com.dew.common.domain.bus.RequestHandler
import com.dew.shops.domain.Shop
import com.dew.shops.domain.ShopRepository
import jakarta.inject.Singleton
import org.reactivestreams.Publisher

@Singleton
class CreateShopCommandHandler(private val repository: ShopRepository) :
    RequestHandler<CreateShopCommand, Publisher<Boolean>> {

    override fun handle(request: CreateShopCommand): Publisher<Boolean> {
        val shop = Shop(
            request.name,
            request.nit,
            request.address,
            request.phone,
            request.userId,
            request.email
        )

        return repository.save(shop)
    }
}