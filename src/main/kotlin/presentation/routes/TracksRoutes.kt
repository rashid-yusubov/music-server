package com.rashidyusubov.musicserver.presentation.routes

import com.rashidyusubov.musicserver.data.mapper.toResponseDto
import com.rashidyusubov.musicserver.data.repository.TracksRepositoryImpl
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.tracksRoutes() {

    val repository = TracksRepositoryImpl()

    route("/tracks") {

        get {

            val tracks = repository
                .getAllTracks()
                .map { it.toResponseDto() }

            call.respond(tracks)
        }

        get("/{id}") {

            val id = call.parameters["id"]?.toIntOrNull()

            if (id == null) {
                call.respond(
                    HttpStatusCode.BadRequest,
                    "Invalid track id"
                )
                return@get
            }

            val track = repository
                .getTrackById(id)

            if (track == null) {
                call.respond(
                    HttpStatusCode.NotFound,
                    "Track not found"
                )
                return@get
            }

            call.respond(track.toResponseDto())
        }

        get("/search") {

            val query = call.request.queryParameters["query"]

            if (query.isNullOrBlank()) {
                call.respond(
                    HttpStatusCode.BadRequest,
                    "Query parameter is required"
                )
                return@get
            }

            val tracks = repository
                .searchTracks(query)
                .map { it.toResponseDto() }

            call.respond(tracks)
        }
    }
}