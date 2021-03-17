rootProject.name = "ksp-builder"
include("builder-processor")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
    }
}
include("data-factory")
