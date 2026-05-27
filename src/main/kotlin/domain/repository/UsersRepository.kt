package com.rashidyusubov.musicserver.domain.repository

import com.rashidyusubov.musicserver.domain.model.User

interface UsersRepository {

    suspend fun getUserByFirebaseUid(
        firebaseUid: String
    ): User?

    suspend fun createUser(
        firebaseUid: String,
        email: String
    ): User
}