package me.gladwell.http4k

import com.typesafe.config.ConfigFactory
import io.github.config4k.*
import org.http4k.core.Body
import org.http4k.core.ContentType.Companion.APPLICATION_JSON
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.server.Jetty
import org.http4k.server.asServer
import org.http4k.core.with
import org.http4k.lens.string

import me.gladwell.http4k.message.format.*

import javax.inject.Inject

class Api @Inject constructor(messages: MessageFactory) {

    val app = { request: Request ->
        val name = request.query("name")
        val json = Message.format().run { json(messages.message(name)) }

        val jsonBody = Body.string(APPLICATION_JSON).toLens()

        Response(OK).with(jsonBody of json)
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
