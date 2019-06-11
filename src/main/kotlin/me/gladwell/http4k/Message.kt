package me.gladwell.http4k

import arrow.extension
import me.gladwell.json.Format

data class Message(val message: String) {
    companion object
}

@extension
interface MessageFormat: Format<Message> {
    override fun json(message: Message): String = "{ \"message\": \"${message.message}\" }"
}
