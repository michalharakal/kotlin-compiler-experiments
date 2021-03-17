import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        /*
        freeCompilerArgs =
            listOf(
                "-Xplugin=${project.rootDir}/builder-plugin-jvm/build/libs/builder-plugin-jvm-0.1.0-SNAPSHOT.jar")

         */

        useIR = true
    }
}

dependencies {
    implementation(kotlin("stdlib"))
    kotlinCompilerPluginClasspath(project(":builder-plugin-jvm"))
}

