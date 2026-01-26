plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-gradle-plugin:3.5.10")
    implementation("io.spring.gradle:dependency-management-plugin:1.1.7")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.3.0")
    implementation("org.jetbrains.kotlin:kotlin-allopen:2.3.0")
    implementation("org.jetbrains.kotlin:kotlin-noarg:2.3.0")
    implementation("com.google.cloud.tools:jib-gradle-plugin:3.5.2")
}