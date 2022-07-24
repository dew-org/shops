package com.dew.shops.application.create

import com.dew.common.domain.bus.Request
import io.micronaut.core.annotation.Introspected
import io.micronaut.core.annotation.ReflectiveAccess
import org.reactivestreams.Publisher
import javax.validation.constraints.NotBlank

@Introspected
@ReflectiveAccess
data class CreateShopCommand(
    @field:NotBlank
    val name: String,

    @field:NotBlank
    val nit: String,

    @field:NotBlank
    val address: String,

    @field:NotBlank
    val phone: String,

    @field:NotBlank
    val userId: String,

    val email: String? = null,
) : Request<Publisher<Boolean>>
