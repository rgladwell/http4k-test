package me.gladwell.http4k

import dagger.Component

@Component(modules = arrayOf(SimpleModule::class))
interface ApiFactory {

    fun api(): Api

}
