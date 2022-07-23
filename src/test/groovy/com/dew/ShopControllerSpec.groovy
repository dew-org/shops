package com.dew

import com.dew.shops.application.create.CreateShopCommand
import io.micronaut.http.HttpStatus
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import io.micronaut.test.support.TestPropertyProvider
import jakarta.inject.Inject
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.spock.Testcontainers
import org.testcontainers.utility.DockerImageName
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
@Testcontainers
class ShopControllerSpec extends Specification implements TestPropertyProvider {

    static MongoDBContainer mongo = new MongoDBContainer(DockerImageName.parse("mongo:latest"))
            .withExposedPorts(27017)

    @Inject
    ShopClient client

    def 'interact with shop api'() {
        when: 'saving a shop'
        var shop = new CreateShopCommand("Dew", "123", "Street", "1234566", "asda23", "dew@dew.com")

        var status = client.save(shop)

        then: 'the shop is saved'
        status == HttpStatus.CREATED
    }

    @Override
    Map<String, String> getProperties() {
        mongo.start()

        return ["mongodb.uri": mongo.replicaSetUrl]
    }
}
