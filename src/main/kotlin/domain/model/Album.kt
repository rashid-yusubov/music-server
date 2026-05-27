package com.rashidyusubov.musicserver.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Album(
    val id: Int,
    val title: String,
    val artistId: Int,
    val coverUrl: String?,
    val releaseYear: Int
)