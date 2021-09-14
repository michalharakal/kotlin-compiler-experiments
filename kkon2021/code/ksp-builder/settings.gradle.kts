rootProject.name = "ksp-builder"
include("builder-processor")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
    }
}
include("app")
include("compiler-plugin")
