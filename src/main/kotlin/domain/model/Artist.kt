package com.rashidyusubov.musicserver.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Artist(
    val id: Int,
    val name: String,
    val avatarUrl: String?,
    val description: String?
)