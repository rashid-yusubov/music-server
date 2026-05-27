package com.rashidyusubov.musicserver.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int,
    val firebaseUid: String,
    val email: String,
    val username: String,
    val avatarUrl: String?
)