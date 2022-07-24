package com.dew.shops.application.findByUser

import com.dew.common.domain.bus.RequestHandler
import com.dew.shops.application.ShopResponse
import com.dew.shops.domain.ShopRepository
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.inject.Singleton
import reactor.core.publisher.Mono

@Singleton
class FindShopByUserQueryHandler(private val repository: ShopRepository, private val objectMapper: ObjectMapper) :
    RequestHandler<FindShopByUserQuery, Mono<ShopResponse>> {

    override fun handle(request: FindShopByUserQuery): Mono<ShopResponse> {
        return Mono.from(repository.findByUserId(request.userId))
            .map {
                objectMapper.convertValue(it, ShopResponse::class.java)
            }
    }
}