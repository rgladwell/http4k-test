package me.gladwell.http4k

import com.typesafe.config.ConfigFactory
import io.github.config4k.*
import org.http4k.core.Body
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.server.Jetty
import org.http4k.server.asServer
import org.http4k.core.with
import org.http4k.format.Jackson.auto

import me.gladwell.johnlewis.*

import javax.inject.Inject

class Api @Inject constructor() {

    val page = ProductListingPage(CategoryId("1"), listOf(BoostRule(ProductId("2"))))

    val app = { request: Request ->
        val jsonBody = Body.auto<ProductListingPage>().toLens()
        Response(OK).with(jsonBody of page)
    }

    companion object {

        fun run() {
            val port = ConfigFactory.load().extract<Int>("server.port")
            val api = DaggerApiFactory.builder()
                .simpleModule(SimpleModule)
                .build()
                .api();
            api.app.asServer(Jetty(port)).start()
        }
    }
}

fun main() {

    println("Starting API")
    Api.run()

}
