package com.dew.shops.infrastructure.persistence.mongo

import com.dew.common.infrastructure.persistence.mongo.MongoDbConfiguration
import com.dew.shops.domain.Shop
import com.dew.shops.domain.ShopRepository
import com.mongodb.client.model.Filters
import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoCollection
import jakarta.inject.Singleton
import org.bson.types.ObjectId
import reactor.core.publisher.Mono

@Singleton
open class MongoDbShopRepository(
    private val mongoDbConfiguration: MongoDbConfiguration, private val mongoClient: MongoClient
) : ShopRepository {

    override fun save(shop: Shop): Mono<Boolean> =
        Mono.from(collection.insertOne(shop))
            .map { true }.onErrorReturn(false)

    override fun findById(id: String): Mono<Shop> = Mono.from(
        collection.find(Filters.eq("_id", ObjectId(id))).first()
    )

    override fun findByUserId(userId: String): Mono<Shop> = Mono.from(
        collection.find(Filters.eq("userId", userId)).first()
    )

    private val collection: MongoCollection<Shop>
        get() = mongoClient.getDatabase(mongoDbConfiguration.name)
            .getCollection(mongoDbConfiguration.collection, Shop::class.java)
}