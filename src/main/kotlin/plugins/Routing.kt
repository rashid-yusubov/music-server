package com.rashidyusubov.musicserver.plugins

import com.rashidyusubov.musicserver.presentation.routes.authRoutes
import com.rashidyusubov.musicserver.presentation.routes.favoritesRoutes
import com.rashidyusubov.musicserver.presentation.routes.playlistsRoutes
import com.rashidyusubov.musicserver.presentation.routes.tracksRoutes
import io.ktor.server.application.*
import io.ktor.server.plugins.swagger.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    routing {

        swaggerUI(
            path = "swagger",
            swaggerFile = "openapi/documentation.yaml"
        )

        tracksRoutes()

        authRoutes()

        favoritesRoutes()

        playlistsRoutes()
    }
}