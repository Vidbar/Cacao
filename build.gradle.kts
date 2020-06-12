plugins {
    kotlin("jvm") version "1.3.61"
    id("org.jetbrains.dokka") version "0.10.0"
}

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation(kotlin("test"))
    testImplementation("junit:junit:4.12")
}

kotlin{
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