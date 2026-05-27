package com.rashidyusubov.musicserver.domain.model

data class Artist(
    val id: Int,
    val name: String,
    val avatarUrl: String?,
    val description: String?
)