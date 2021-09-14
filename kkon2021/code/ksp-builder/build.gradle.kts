plugins {
    kotlin("jvm") version "1.5.30" apply false
}

buildscript {
    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.5.30"))
    }
}

allprojects {
    allprojects {
        repositories {
            google()
            mavenCentral()
            maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
            //       maven(url = "https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-js-wrappers")
        }
    }
}