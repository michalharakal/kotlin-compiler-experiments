buildscript {
  extra["kotlin_plugin_id"] = "com.bnorm.template.kotlin-ir-plugin"
  repositories {
    google()
    mavenCentral()
    jcenter()
  }
}

plugins {
  kotlin("jvm") version "1.4.31" apply false
  id("org.jetbrains.dokka") version "0.10.1" apply false
  id("com.gradle.plugin-publish") version "0.12.0" apply false
  id("com.github.gmazzo.buildconfig") version "2.1.0" apply false
}

allprojects {
  group = "org.dukecon"
  version = "0.1.0-SNAPSHOT"
}

subprojects {
  repositories {
    mavenCentral()
    jcenter()
  }
}
