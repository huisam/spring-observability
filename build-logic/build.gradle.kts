plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-gradle-plugin:3.3.5")
    implementation("io.spring.gradle:dependency-management-plugin:1.1.7")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.1.0")
    implementation("org.jetbrains.kotlin:kotlin-allopen:2.1.0")
    implementation("org.jetbrains.kotlin:kotlin-noarg:2.1.0")
    implementation("com.google.cloud.tools:jib-gradle-plugin:3.4.4")
}