package com.rashidyusubov.musicserver.presentation.middleware

import com.google.firebase.auth.FirebaseAuth
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*

suspend fun verifyFirebaseToken(
    call: ApplicationCall
): String? {

    val authHeader = call.request.headers["Authorization"]

    if (authHeader.isNullOrBlank()) {

        call.respond(
            HttpStatusCode.Unauthorized,
            "Missing authorization token"
        )

        return null
    }

    val token = authHeader
        .removePrefix("Bearer ")
        .trim()

    return try {

        val decodedToken = FirebaseAuth
            .getInstance()
            .verifyIdToken(token)

        decodedToken.uid

    } catch (e: Exception) {

        call.respond(
            HttpStatusCode.Unauthorized,
            "Invalid Firebase token"
        )

        null
    }
}