package com.dew

import com.dew.shops.application.create.CreateShopCommand
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client

import javax.validation.Valid

@Client("/shops")
interface ShopClient {

    @Post
    HttpStatus save(@Valid CreateShopCommand command)
}
