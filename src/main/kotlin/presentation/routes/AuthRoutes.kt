package com.rashidyusubov.musicserver.presentation.routes

import com.rashidyusubov.musicserver.presentation.middleware.verifyFirebaseToken
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.authRoutes() {

    route("/auth") {

        get("/me") {

            val firebaseUid = verifyFirebaseToken(call)
                ?: return@get

            call.respond(
                mapOf(
                    "firebaseUid" to firebaseUid
                )
            )
        }
    }
}