package me.gladwell.http4k

interface MessageFactory {

    fun message(name: String?): Message

}
