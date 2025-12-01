plugins {
    kotlin("jvm") version "2.2.20"
}

group = "de.bergenholtz"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    testImplementation ("io.kotest:kotest-assertions-core:6.0.5")
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
}

tasks.test {
    useJUnitPlatform()
}