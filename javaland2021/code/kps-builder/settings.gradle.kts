rootProject.name = "kps-builder"
include("builder-processor")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
    }
}
include("data-factory")
