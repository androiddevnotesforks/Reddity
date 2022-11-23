pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://jitpack.io")
    }
}

include(":app")
include(":core:auth")
include(":core:base")
include(":core:data")
include(":core:domain")
include(":core:model")
include(":core:network")
include(":core:ui")
include(":feature:chat")
include(":feature:createpost")
include(":feature:explore")
include(":feature:home")
include(":feature:notification")
enableFeaturePreview("VERSION_CATALOGS")
