package com.rashidyusubov.musicserver.presentation.routes

import com.rashidyusubov.musicserver.data.dto.CreatePlaylistRequest
import com.rashidyusubov.musicserver.data.repository.PlaylistsRepositoryImpl
import com.rashidyusubov.musicserver.data.repository.UsersRepositoryImpl
import com.rashidyusubov.musicserver.presentation.middleware.verifyFirebaseToken
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.playlistsRoutes() {

    val playlistsRepository = PlaylistsRepositoryImpl()

    val usersRepository = UsersRepositoryImpl()

    route("/playlists") {

        get {

            val firebaseUid = verifyFirebaseToken(call)
                ?: return@get

            val user = usersRepository
                .getUserByFirebaseUid(firebaseUid)
                ?: return@get

            val playlists = playlistsRepository
                .getPlaylists(user.id)

            call.respond(playlists)
        }

        post {

            val firebaseUid = verifyFirebaseToken(call)
                ?: return@post

            val user = usersRepository
                .getUserByFirebaseUid(firebaseUid)
                ?: return@post

            val request =
                call.receive<CreatePlaylistRequest>()

            playlistsRepository.createPlaylist(
                userId = user.id,
                title = request.title,
                description = request.description
            )

            call.respond(
                HttpStatusCode.Created,
                "Playlist created"
            )
        }

        delete("/{playlistId}") {

            val firebaseUid = verifyFirebaseToken(call)
                ?: return@delete

            usersRepository
                .getUserByFirebaseUid(firebaseUid)
                ?: return@delete

            val playlistId = call.parameters["playlistId"]
                ?.toIntOrNull()

            if (playlistId == null) {

                call.respond(
                    HttpStatusCode.BadRequest,
                    "Invalid playlist id"
                )

                return@delete
            }

            playlistsRepository.deletePlaylist(
                playlistId
            )

            call.respond(
                HttpStatusCode.OK,
                "Playlist deleted"
            )
        }

        post("/{playlistId}/tracks/{trackId}") {

            val firebaseUid = verifyFirebaseToken(call)
                ?: return@post

            usersRepository
                .getUserByFirebaseUid(firebaseUid)
                ?: return@post

            val playlistId = call.parameters["playlistId"]
                ?.toIntOrNull()

            val trackId = call.parameters["trackId"]
                ?.toIntOrNull()

            if (playlistId == null || trackId == null) {

                call.respond(
                    HttpStatusCode.BadRequest,
                    "Invalid ids"
                )

                return@post
            }

            playlistsRepository.addTrackToPlaylist(
                playlistId,
                trackId
            )

            call.respond(
                HttpStatusCode.OK,
                "Track added to playlist"
            )
        }

        delete("/{playlistId}/tracks/{trackId}") {

            val firebaseUid = verifyFirebaseToken(call)
                ?: return@delete

            usersRepository
                .getUserByFirebaseUid(firebaseUid)
                ?: return@delete

            val playlistId = call.parameters["playlistId"]
                ?.toIntOrNull()

            val trackId = call.parameters["trackId"]
                ?.toIntOrNull()

            if (playlistId == null || trackId == null) {

                call.respond(
                    HttpStatusCode.BadRequest,
                    "Invalid ids"
                )

                return@delete
            }

            playlistsRepository.removeTrackFromPlaylist(
                playlistId,
                trackId
            )

            call.respond(
                HttpStatusCode.OK,
                "Track removed from playlist"
            )
        }

        get("/{playlistId}/tracks") {

            val firebaseUid = verifyFirebaseToken(call)
                ?: return@get

            usersRepository
                .getUserByFirebaseUid(firebaseUid)
                ?: return@get

            val playlistId = call.parameters["playlistId"]
                ?.toIntOrNull()

            if (playlistId == null) {

                call.respond(
                    HttpStatusCode.BadRequest,
                    "Invalid playlist id"
                )

                return@get
            }

            val tracks = playlistsRepository
                .getPlaylistTracks(playlistId)

            call.respond(tracks)
        }
    }
}