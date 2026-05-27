package com.rashidyusubov.musicserver.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CreatePlaylistRequest(
    val title: String,
    val description: String?
)