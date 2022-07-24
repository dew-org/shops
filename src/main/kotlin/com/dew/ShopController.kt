package com.dew

import com.dew.common.domain.bus.Mediator
import com.dew.shops.application.ShopResponse
import com.dew.shops.application.create.CreateShopCommand
import com.dew.shops.application.findByUser.FindShopByUserQuery
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.QueryValue
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import reactor.core.publisher.Mono
import javax.validation.Valid

@Controller("/shops")
@Secured(SecurityRule.IS_AUTHENTICATED)
open class ShopController(private val mediator: Mediator) {

    @Post
    open fun save(@Valid command: CreateShopCommand): Mono<HttpStatus> {
        return Mono.from(mediator.send(command))
            .map { added: Boolean -> if (added) HttpStatus.CREATED else HttpStatus.CONFLICT }
    }

    @Get
    open fun findByUserId(@QueryValue("userId") userId: String): Mono<HttpResponse<ShopResponse>> {
        return mediator.send(FindShopByUserQuery(userId))
            .map { shop: ShopResponse? -> if (shop != null) HttpResponse.ok(shop) else HttpResponse.notFound() }
    }
}