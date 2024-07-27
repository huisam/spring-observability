plugins {
    kotlin("jvm") version "1.9.24"
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
