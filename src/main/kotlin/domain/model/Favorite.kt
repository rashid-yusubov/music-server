package com.rashidyusubov.musicserver.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Favorite(
    val id: Int,
    val userId: Int,
    val trackId: Int
)