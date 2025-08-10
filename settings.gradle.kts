rootProject.name = "spring-observability"

pluginManagement {
    includeBuild("build-logic")
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

include("order-application")
include("product-application")
