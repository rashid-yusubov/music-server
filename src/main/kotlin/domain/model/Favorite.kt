package com.rashidyusubov.musicserver.domain.model

data class Favorite(
    val id: Int,
    val userId: Int,
    val trackId: Int
)