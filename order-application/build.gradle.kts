import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot") version "3.3.1"
    id("io.spring.dependency-management") version "1.1.6"
    id("com.google.cloud.tools.jib") version "3.4.3"
    kotlin("plugin.jpa") version "2.0.20"
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.24"
}

group = "com.huisam"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

val agent = configurations.create("agent")

extra["springCloudVersion"] = "2023.0.2"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("io.github.openfeign:feign-micrometer")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    runtimeOnly("org.postgresql:postgresql")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    agent("io.opentelemetry.javaagent:opentelemetry-javaagent:2.7.0")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

kotlin {
    jvmToolchain {
        languageVersion = JavaLanguageVersion.of(21)
        vendor = JvmVendorSpec.ADOPTIUM
    }
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

val copyAgent = tasks.register<Copy>("copyAgent") {
    from(agent.singleFile)
    into(layout.buildDirectory.dir("agent"))
    rename("opentelemetry-javaagent-.*\\.jar", "opentelemetry-javaagent.jar")
}


tasks.named<BootJar>("bootJar") {
    dependsOn(copyAgent)

    archiveFileName = "app.jar"
}

jib {
    from {
        image = "eclipse-temurin:21-jdk"
        platforms {
            platform {
                architecture = "arm64"
                os = "linux"
            }
        }
    }

    extraDirectories {
        paths {
            path {
                setFrom(layout.buildDirectory.dir("agent"))
                into = "/otelagent"
            }
        }
    }

    container {
        mainClass = "com.huisam.orderapplication.OrderApplicationKt"
        jvmFlags = listOf(
            "-javaagent:/otelagent/opentelemetry-javaagent.jar"
        )
    }
}

tasks.named("jibDockerBuild").configure {
    dependsOn(copyAgent)
}