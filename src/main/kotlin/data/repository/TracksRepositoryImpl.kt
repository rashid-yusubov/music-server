package com.rashidyusubov.musicserver.data.repository

import com.rashidyusubov.musicserver.domain.model.Track
import com.rashidyusubov.musicserver.domain.repository.TracksRepository

class TracksRepositoryImpl : TracksRepository {

    override suspend fun getAllTracks(): List<Track> {
        return emptyList()
    }

    override suspend fun getTrackById(id: Int): Track? {
        return null
    }

    override suspend fun searchTracks(query: String): List<Track> {
        return emptyList()
    }
}