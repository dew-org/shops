package com.dew.shops.domain

import io.micronaut.core.annotation.Creator
import io.micronaut.core.annotation.Introspected
import io.micronaut.core.annotation.ReflectiveAccess
import org.bson.codecs.pojo.annotations.BsonCreator
import org.bson.codecs.pojo.annotations.BsonProperty
import org.bson.types.ObjectId
import java.time.Clock
import java.time.Instant
import java.util.Date

@Introspected
@ReflectiveAccess
data class Shop @Creator @BsonCreator constructor(
    @field:BsonProperty("name")
    @param:BsonProperty("name")
    val name: String,

    @field:BsonProperty("nit")
    @param:BsonProperty("nit")
    val nit: String,

    @field:BsonProperty("address")
    @param:BsonProperty("address")
    val address: String,

    @field:BsonProperty("phone")
    @param:BsonProperty("phone")
    val phone: String,

    @field:BsonProperty("userId")
    @param:BsonProperty("userId")
    val userId: String,

    @field:BsonProperty("email")
    @param:BsonProperty("email")
    val email: String? = null,

    @field:BsonProperty("_id")
    @param:BsonProperty("_id")
    val id: ObjectId? = null,
) {
    @field:BsonProperty("createdAt")
    val createdAt: Date = Date.from(Instant.now(Clock.systemUTC()))
}
