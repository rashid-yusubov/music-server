plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(ktorLibs.plugins.ktor)
    alias(libs.plugins.kotlin.serialization)
}

group = "com.rashidyusubov.musicserver"
version = "1.0.0-SNAPSHOT"

application {
    mainClass = "io.ktor.server.netty.EngineMain"
}

kotlin {
    jvmToolchain(21)
}
dependencies {
    implementation(ktorLibs.serialization.kotlinx.json)
    implementation(ktorLibs.server.callLogging)
    implementation(ktorLibs.server.config.yaml)
    implementation(ktorLibs.server.contentNegotiation)
    implementation(ktorLibs.server.core)
    implementation(ktorLibs.server.netty)
    implementation(libs.logback.classic)

    // Koin
    implementation("io.insert-koin:koin-ktor:3.5.6")
    implementation("io.insert-koin:koin-logger-slf4j:3.5.6")

    // PostgreSQL
    implementation("org.postgresql:postgresql:42.7.3")

    // Exposed
    implementation("org.jetbrains.exposed:exposed-core:0.50.1")
    implementation("org.jetbrains.exposed:exposed-dao:0.50.1")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.50.1")

    // HikariCP
    implementation("com.zaxxer:HikariCP:5.1.0")

    // dotenv
    implementation("io.github.cdimascio:dotenv-kotlin:6.4.1")

    // Swagger/OpenAPI
    implementation("io.ktor:ktor-server-swagger:2.3.12")
    implementation("io.ktor:ktor-server-openapi:2.3.12")

    // Firebase
    implementation("com.google.firebase:firebase-admin:9.3.0")

    // Status Page
    implementation("io.ktor:ktor-server-status-pages:3.5.0")

    testImplementation(kotlin("test"))
    testImplementation(ktorLibs.server.testHost)
}
