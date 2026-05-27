package com.rashidyusubov.musicserver.presentation.routes

import com.google.firebase.auth.FirebaseAuth
import com.rashidyusubov.musicserver.data.repository.UsersRepositoryImpl
import com.rashidyusubov.musicserver.presentation.middleware.verifyFirebaseToken
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.authRoutes() {

    val usersRepository = UsersRepositoryImpl()

    route("/auth") {

        get("/me") {

            val firebaseUid = verifyFirebaseToken(call)
                ?: return@get

            var user = usersRepository
                .getUserByFirebaseUid(firebaseUid)

            if (user == null) {

                val firebaseUser = FirebaseAuth
                    .getInstance()
                    .getUser(firebaseUid)

                user = usersRepository.createUser(
                    firebaseUid = firebaseUid,
                    email = firebaseUser.email ?: ""
                )
            }

            call.respond(user)
        }
    }
}