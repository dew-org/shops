package com.dew

import com.dew.shops.application.ShopService
import com.dew.shops.application.create.CreateShopCommand
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import reactor.core.publisher.Mono
import javax.validation.Valid

@Controller("/shops")
@Secured(SecurityRule.IS_AUTHENTICATED)
open class ShopController(private val shopService: ShopService) {

    @Post
    open fun save(@Valid command: CreateShopCommand): Mono<HttpStatus> {
        return shopService.save(command)
            .map { added: Boolean -> if (added) HttpStatus.CREATED else HttpStatus.CONFLICT }
    }
}