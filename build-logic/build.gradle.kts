plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-gradle-plugin:3.3.4")
    implementation("io.spring.gradle:dependency-management-plugin:1.1.6")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.25")
    implementation("org.jetbrains.kotlin:kotlin-allopen:1.9.25")
    implementation("org.jetbrains.kotlin:kotlin-noarg:1.9.25")
    implementation("com.google.cloud.tools:jib-gradle-plugin:3.4.3")
}