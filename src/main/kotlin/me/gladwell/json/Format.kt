package me.gladwell.json

interface Format<T> {

    fun json(t: T): String

    companion object {

        fun <T>toJson(o: T, format: Format<T>): String {
            return format.run{ json(o) };
        }
    }
}
