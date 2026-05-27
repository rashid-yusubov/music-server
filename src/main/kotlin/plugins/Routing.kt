package com.rashidyusubov.musicserver.plugins

import com.rashidyusubov.musicserver.presentation.routes.tracksRoutes
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    routing {

        tracksRoutes()
    }
}