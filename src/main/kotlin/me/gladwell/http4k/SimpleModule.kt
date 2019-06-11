package me.gladwell.http4k

import dagger.Module
import dagger.Provides

@Module
internal object SimpleModule {

    @Provides
    fun provideGreetingsFactory(): MessageFactory {
        return GreetingsMessageFactory
    }

}
