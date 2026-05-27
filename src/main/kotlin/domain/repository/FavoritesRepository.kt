package com.rashidyusubov.musicserver.domain.repository

import com.rashidyusubov.musicserver.domain.model.Track

interface FavoritesRepository {

    suspend fun getFavorites(
        userId: Int
    ): List<Track>

    suspend fun addToFavorites(
        userId: Int,
        trackId: Int
    )

    suspend fun removeFromFavorites(
        userId: Int,
        trackId: Int
    )
}