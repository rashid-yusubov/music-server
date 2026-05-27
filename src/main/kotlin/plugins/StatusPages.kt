package com.rashidyusubov.musicserver.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*

fun Application.configureStatusPages() {

    install(StatusPages) {

        exception<Throwable> { call, cause ->

            call.respond(
                HttpStatusCode.InternalServerError,
                mapOf("error" to (cause.message ?: "Unknown error")
                )
            )
        }

        status(HttpStatusCode.NotFound) { call, status ->

            call.respond(
                status,
                mapOf("error" to "Resource not found")
            )
        }

        status(HttpStatusCode.BadRequest) { call, status ->

            call.respond(
                status,
                mapOf("error" to "Bad request")
            )
        }
    }
}