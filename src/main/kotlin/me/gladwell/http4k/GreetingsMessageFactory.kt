package me.gladwell.http4k

object GreetingsMessageFactory : MessageFactory {

    override fun message(name: String?): Message = Message("Hello, $name")

}
