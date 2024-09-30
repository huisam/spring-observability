import gradle.kotlin.dsl.accessors._b8a265932296deb6b8c2e61dc5dc689b.implementation
import gradle.kotlin.dsl.accessors._b8a265932296deb6b8c2e61dc5dc689b.testImplementation
import gradle.kotlin.dsl.accessors._b8a265932296deb6b8c2e61dc5dc689b.testRuntimeOnly
import org.gradle.kotlin.dsl.extra

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

extra["springCloudVersion"] = "2023.0.3"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("io.github.openfeign:feign-micrometer")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}