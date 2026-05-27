package com.rashidyusubov.musicserver.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class TrackResponseDto(
    val id: Int,
    val title: String,
    val artistId: Int,
    val albumId: Int,
    val duration: Int,
    val genre: String,
    val audioUrl: String,
    val coverUrl: String?
)