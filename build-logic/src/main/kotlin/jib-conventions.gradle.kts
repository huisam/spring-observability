import org.gradle.api.tasks.Copy
import org.gradle.kotlin.dsl.*
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("com.google.cloud.tools.jib")
}

val agent = configurations.create("agent")

dependencies {
    agent("io.opentelemetry.javaagent:opentelemetry-javaagent:2.9.0")
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