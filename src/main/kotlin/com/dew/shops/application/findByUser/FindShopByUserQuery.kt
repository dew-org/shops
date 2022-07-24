package com.dew.shops.application.findByUser

import com.dew.common.domain.bus.Request
import com.dew.shops.application.ShopResponse
import reactor.core.publisher.Mono

data class FindShopByUserQuery(val userId: String) : Request<Mono<ShopResponse>>
