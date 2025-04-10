rootProject.name = "spring-observability"

pluginManagement {
    includeBuild("build-logic")
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.10.0"
}

include("order-application")
include("product-application")
