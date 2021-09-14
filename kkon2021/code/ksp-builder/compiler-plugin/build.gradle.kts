val kspVersion: String by project

plugins {
    kotlin("jvm")
}

group = "org.dukecon"
version = "1.0-SNAPSHOT"

dependencies {
    //implementation("com.square:javapoet:1.12.1")
    implementation("com.google.devtools.ksp:symbol-processing-api:$kspVersion")
    implementation("com.squareup:javapoet:1.12.1")

    testImplementation(kotlin("test"))
    testImplementation("com.github.tschuchortdev:kotlin-compile-testing-ksp:1.4.4")
    testImplementation("org.mockito:mockito-core:3.12.4")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
    testImplementation("org.assertj:assertj-core:3.20.2")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}


