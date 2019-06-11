# http4k Test Project

This test project demos Ktor and Dagger 2 for Kotlin web service development.

To run:

```sh
$ ./gradlew run

```

## Intellij IDEA

In order to get Dagger 2 compile-time dependency injection working you need to follow these steps:

In `Build Tools -> Gradle -> Runner`, you can tick the setting `Delegate IDE build/run actions to gradle` so that IntelliJ will use gradle for your project.