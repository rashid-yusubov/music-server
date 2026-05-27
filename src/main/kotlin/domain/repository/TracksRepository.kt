package com.rashidyusubov.musicserver.domain.repository

import com.rashidyusubov.musicserver.domain.model.Track

interface TracksRepository {

    suspend fun getAllTracks(): List<Track>

    suspend fun getTrackById(id: Int): Track?

    suspend fun searchTracks(query: String): List<Track>
}