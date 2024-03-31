plugins {
    kotlin("jvm") version "1.9.23"
    application
}

kotlin {
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