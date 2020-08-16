plugins {
    kotlin("jvm") version "1.3.71"
    id("org.jetbrains.dokka") version "0.10.0"
    id("org.jlleitschuh.gradle.ktlint") version "9.3.0"
}

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.8")
    implementation(kotlin("test"))

    implementation("com.1stleg:jnativehook:2.1.0")

    testImplementation("junit:junit:4.12")
}

kotlin {
    sourceSets["main"].apply {
        kotlin.srcDir("src")
    }
    sourceSets["test"].apply {
        kotlin.srcDir("test")
    }
}

tasks.dokka {
    outputFormat = "html"
    outputDirectory = "$buildDir/javadoc"
}
