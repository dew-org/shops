package com.dew

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/")
class Home {

    @Get("/")
    fun index(): String {
        return "Hello World!"
    }
}