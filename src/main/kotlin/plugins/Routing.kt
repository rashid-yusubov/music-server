package com.rashidyusubov.musicserver.plugins

import com.rashidyusubov.musicserver.presentation.routes.albumsRoutes
import com.rashidyusubov.musicserver.presentation.routes.artistsRoutes
import com.rashidyusubov.musicserver.presentation.routes.authRoutes
import com.rashidyusubov.musicserver.presentation.routes.favoritesRoutes
import com.rashidyusubov.musicserver.presentation.routes.playlistsRoutes
import com.rashidyusubov.musicserver.presentation.routes.tracksRoutes
import io.ktor.server.application.*
import io.ktor.server.http.content.staticResources
import io.ktor.server.plugins.swagger.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    routing {

        swaggerUI(
            path = "swagger",
            swaggerFile = "openapi/documentation.yaml"
        )


        staticResources("/music", "static/music")

        staticResources("/images", "static/images")

        tracksRoutes()

        albumsRoutes()

        artistsRoutes()

        authRoutes()

        favoritesRoutes()

        playlistsRoutes()
    }
}