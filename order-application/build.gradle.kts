plugins {
    id("common-conventions")
    id("kotlin-conventions")
    id("spring-conventions")
    id("jib-conventions")
}

dependencies {
    runtimeOnly("org.postgresql:postgresql")
}