package com.rashidyusubov.musicserver.presentation.routes

import com.rashidyusubov.musicserver.data.mapper.toResponseDto
import com.rashidyusubov.musicserver.data.repository.AlbumsRepositoryImpl
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.albumsRoutes() {

    val repository = AlbumsRepositoryImpl()

    route("/albums") {

        get {

            val albums = repository
                .getAlbums()

            call.respond(albums)
        }

        get("/{id}") {

            val id = call.parameters["id"]
                ?.toIntOrNull()

            if (id == null) {

                call.respond(
                    HttpStatusCode.BadRequest,
                    "Invalid album id"
                )

                return@get
            }

            val album = repository
                .getAlbumById(id)

            if (album == null) {

                call.respond(
                    HttpStatusCode.NotFound,
                    "Album not found"
                )

                return@get
            }

            call.respond(album)
        }

        get("/{id}/tracks") {

            val id = call.parameters["id"]
                ?.toIntOrNull()

            if (id == null) {

                call.respond(
                    HttpStatusCode.BadRequest,
                    "Invalid album id"
                )

                return@get
            }

            val tracks = repository
                .getAlbumTracks(id)
                .map { it.toResponseDto() }

            call.respond(tracks)
        }
    }
}