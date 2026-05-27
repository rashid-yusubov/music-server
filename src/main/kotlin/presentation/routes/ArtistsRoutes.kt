package com.rashidyusubov.musicserver.presentation.routes

import com.rashidyusubov.musicserver.data.mapper.toResponseDto
import com.rashidyusubov.musicserver.data.repository.ArtistsRepositoryImpl
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.artistsRoutes() {

    val repository = ArtistsRepositoryImpl()

    route("/artists") {

        get {

            val artists = repository
                .getArtists()

            call.respond(artists)
        }

        get("/{id}") {

            val id = call.parameters["id"]
                ?.toIntOrNull()

            if (id == null) {

                call.respond(
                    HttpStatusCode.BadRequest,
                    "Invalid artist id"
                )

                return@get
            }

            val artist = repository
                .getArtistById(id)

            if (artist == null) {

                call.respond(
                    HttpStatusCode.NotFound,
                    "Artist not found"
                )

                return@get
            }

            call.respond(artist)
        }

        get("/{id}/tracks") {

            val id = call.parameters["id"]
                ?.toIntOrNull()

            if (id == null) {

                call.respond(
                    HttpStatusCode.BadRequest,
                    "Invalid artist id"
                )

                return@get
            }

            val tracks = repository
                .getArtistTracks(id)
                .map { it.toResponseDto() }

            call.respond(tracks)
        }

        get("/{id}/albums") {

            val id = call.parameters["id"]
                ?.toIntOrNull()

            if (id == null) {

                call.respond(
                    HttpStatusCode.BadRequest,
                    "Invalid artist id"
                )

                return@get
            }

            val albums = repository
                .getArtistAlbums(id)

            call.respond(albums)
        }
    }
}