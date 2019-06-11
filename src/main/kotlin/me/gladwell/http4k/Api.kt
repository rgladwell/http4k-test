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

fun main() {

    val app = { request: Request ->
        val message = Message("Hello, ${request.query("name")}!")

        val json = Message.format().run { json(message) }

        val jsonBody = Body.string(APPLICATION_JSON).toLens()

        Response(OK).with(jsonBody of json)

    }

    println("Starting API")
    val port = ConfigFactory.load().extract<Int>("server.port")
    app.asServer(Jetty(port)).start()

}
