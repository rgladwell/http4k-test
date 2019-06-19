val kotlinVersion = "1.3.21"
val http4kVersion = "3.154.0"
val arrowVersion = "0.9.0"
val daggerVersion = "2.23.1"
val spekVersion = "2.0.5"

plugins {
    id("org.jetbrains.kotlin.jvm").version("1.3.21")
    application
    kotlin("kapt") version "1.3.21"
}

repositories {
    jcenter()
    maven("https://jitpack.io")
    maven("https://dl.bintray.com/spekframework/spek/")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

    // http4k
    compile("org.http4k:http4k-core:$http4kVersion")
    compile("org.http4k:http4k-server-jetty:$http4kVersion")
    compile("org.http4k:http4k-format-jackson:$http4kVersion")

    // arrow
    compile("io.arrow-kt:arrow-core-extensions:$arrowVersion")
    compile("io.arrow-kt:arrow-extras-data:$arrowVersion")
    kapt("io.arrow-kt:arrow-meta:$arrowVersion")

    // config4k
    compile("io.github.config4k:config4k:0.4.1")

    // dagger
    compile("com.google.dagger:dagger:$daggerVersion")
    kapt("com.google.dagger:dagger-compiler:$daggerVersion")

    // spek
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:$spekVersion")
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:$spekVersion")
    testRuntimeOnly("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
    testImplementation("com.natpryce:hamkrest:1.7.0.0")
}

application {
    mainClassName = "me.gladwell.http4k.ApiKt"
}

tasks.test {
    useJUnitPlatform {
        includeEngines("spek2")
    }
}
