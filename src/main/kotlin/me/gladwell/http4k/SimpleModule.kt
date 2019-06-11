package me.gladwell.http4k

import toothpick.config.Module

internal object SimpleModule : Module() {

    init {
        bind(MessageFactory::class.java).toInstance(GreetingsMessageFactory)
    }

}
