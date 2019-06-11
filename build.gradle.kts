val http4kVersion = "3.154.0"
val arrowVersion = "0.9.0"
val daggerVersion = "2.23.1"

plugins {
    id("org.jetbrains.kotlin.jvm").version("1.3.21")
    application
    kotlin("kapt") version "1.3.31"
}

repositories {
    jcenter()
    maven("https://jitpack.io")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

    compile("org.http4k:http4k-core:$http4kVersion")
    compile("org.http4k:http4k-server-jetty:$http4kVersion")

    compile("io.arrow-kt:arrow-core-extensions:$arrowVersion")
    kapt("io.arrow-kt:arrow-meta:$arrowVersion")

    compile("io.github.config4k:config4k:0.4.1")

    compile("com.google.dagger:dagger:$daggerVersion")
    kapt("com.google.dagger:dagger-compiler:$daggerVersion")
}

application {
    mainClassName = "me.gladwell.http4k.ApiKt"
}
