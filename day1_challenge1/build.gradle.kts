plugins {
    kotlin("jvm") version "1.9.23"
    application
}

kotlin {
    jvmToolchain(8)
    sourceSets {
        main {
            kotlin.srcDir("src")
        }
    }
}

application {
    mainClass = "MainKt"
}

repositories {
    mavenCentral()
}