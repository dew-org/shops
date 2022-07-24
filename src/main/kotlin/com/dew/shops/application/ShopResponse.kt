package com.dew.shops.application

import io.micronaut.core.annotation.Introspected
import io.micronaut.core.annotation.ReflectiveAccess
import org.bson.types.ObjectId
import java.util.*

@Introspected
@ReflectiveAccess
data class ShopResponse(
    val id: ObjectId,
    val name: String,
    val nit: String,
    val address: String,
    val phone: String,
    val userId: String,
    val email: String?,
    val createdAt: Date
)
