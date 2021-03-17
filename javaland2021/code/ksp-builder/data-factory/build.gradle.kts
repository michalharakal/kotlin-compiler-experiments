plugins {
    id("com.google.devtools.ksp") version "1.4.30-1.0.0-alpha04"
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
    implementation(kotlin("stdlib"))
    implementation(project(":builder-processor"))
    ksp(project(":builder-processor"))
}

ksp {
    arg("option1", "value1")
    arg("option2", "value2")
}