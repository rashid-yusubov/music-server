package com.rashidyusubov.musicserver.presentation.routes

import com.google.firebase.auth.FirebaseAuth
import com.rashidyusubov.musicserver.data.mapper.toResponseDto
import com.rashidyusubov.musicserver.data.repository.FavoritesRepositoryImpl
import com.rashidyusubov.musicserver.data.repository.UsersRepositoryImpl
import com.rashidyusubov.musicserver.presentation.middleware.verifyFirebaseToken
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.favoritesRoutes() {

    val favoritesRepository = FavoritesRepositoryImpl()

    val usersRepository = UsersRepositoryImpl()

    route("/favorites") {

        get {

            val firebaseUid = verifyFirebaseToken(call)
                ?: return@get

            val user = usersRepository
                .getUserByFirebaseUid(firebaseUid)
                ?: return@get

            val favorites = favoritesRepository
                .getFavorites(user.id)
                .map { it.toResponseDto() }

            call.respond(favorites)
        }

        post("/{trackId}") {

            val firebaseUid = verifyFirebaseToken(call)
                ?: return@post

            val user = usersRepository
                .getUserByFirebaseUid(firebaseUid)
                ?: return@post

            val trackId = call.parameters["trackId"]
                ?.toIntOrNull()

            if (trackId == null) {

                call.respond(
                    HttpStatusCode.BadRequest,
                    "Invalid track id"
                )

                return@post
            }

            favoritesRepository.addToFavorites(
                user.id,
                trackId
            )

            call.respond(
                HttpStatusCode.OK,
                "Track added to favorites"
            )
        }

        delete("/{trackId}") {

            val firebaseUid = verifyFirebaseToken(call)
                ?: return@delete

            val user = usersRepository
                .getUserByFirebaseUid(firebaseUid)
                ?: return@delete

            val trackId = call.parameters["trackId"]
                ?.toIntOrNull()

            if (trackId == null) {

                call.respond(
                    HttpStatusCode.BadRequest,
                    "Invalid track id"
                )

                return@delete
            }

            favoritesRepository.removeFromFavorites(
                user.id,
                trackId
            )

            call.respond(
                HttpStatusCode.OK,
                "Track removed from favorites"
            )
        }
    }
}