plugins {
    id("com.google.devtools.ksp") version "1.5.30-1.0.0"
    kotlin("jvm")
}
sourceSets.getByName("main") {
    java.srcDir("src/main/java")
    java.srcDir("src/main/kotlin")
    java.srcDir("build/generated/ksp/main")
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation(project(":compiler-plugin"))
    ksp(project(":compiler-plugin"))
}

ksp {
    arg("option1", "value1")
    arg("option2", "value2")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}