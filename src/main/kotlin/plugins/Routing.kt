package com.rashidyusubov.musicserver.plugins

import com.rashidyusubov.musicserver.presentation.routes.tracksRoutes
import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.server.plugins.swagger.*

fun Application.configureRouting() {

    routing {

        swaggerUI(
            path = "swagger",
            swaggerFile = "openapi/documentation.yaml"
        )

        tracksRoutes()
    }
}