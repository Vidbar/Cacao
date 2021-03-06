plugins {
    kotlin("jvm") version "1.4.10"
    id("org.jetbrains.dokka") version "1.4.32"
}

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9")
    implementation(kotlin("test"))

    implementation("com.1stleg:jnativehook:2.1.0")

    testImplementation("junit:junit:4.12")
}

kotlin {
    explicitApi()
    sourceSets["main"].apply {
        kotlin.srcDir("src")
    }
    sourceSets["test"].apply {
        kotlin.srcDir("test")
    }
}
