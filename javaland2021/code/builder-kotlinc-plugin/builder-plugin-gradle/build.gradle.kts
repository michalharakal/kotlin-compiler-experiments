import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("java-gradle-plugin")
  kotlin("jvm")
  id("com.github.gmazzo.buildconfig")
  `maven-publish`
}

dependencies {
  implementation(kotlin("stdlib"))
  implementation(kotlin("gradle-plugin-api"))
}

buildConfig {
  packageName("com.bnorm.template")
  buildConfigField("String", "KOTLIN_PLUGIN_ID", "\"123\"")
  buildConfigField("String", "KOTLIN_PLUGIN_GROUP", "\"123\"")
  buildConfigField("String", "KOTLIN_PLUGIN_NAME", "\"123\"")
  buildConfigField("String", "KOTLIN_PLUGIN_VERSION", "\"123\"")


}

version = "0.0.1"
group = "kotlin.plugin.experiments"


tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "1.8"
}

gradlePlugin {
  plugins {
    create("kotlin.experiments.plugin") {
      id = "kotlin.experiments.plugin"
      implementationClass = "com.bnorm.template.TemplateGradlePlugin"
      description = ""
    }
  }
}

publishing {
  publications {
    // the name of this publication should match the name java-gradle-plugin looks up
    // https://github.com/gradle/gradle/blob/master/subprojects/plugin-development/src/main/java/org/gradle/plugin/devel/plugins/MavenPluginPublishPlugin.java#L73
    this.create<MavenPublication>("pluginMaven") {
      artifactId = "kotlin.experiments.plugin"
      pom {
        name.set("kotlin.experiments.plugin")
        description.set("Kotlin symbol processing integration for Gradle")
      }
    }
  }
}
