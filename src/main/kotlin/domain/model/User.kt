package com.rashidyusubov.musicserver.domain.model

data class User(
    val id: Int,
    val firebaseUid: String,
    val email: String,
    val username: String,
    val avatarUrl: String?
)