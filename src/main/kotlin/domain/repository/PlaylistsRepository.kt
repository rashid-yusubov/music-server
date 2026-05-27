package com.rashidyusubov.musicserver.domain.repository

import com.rashidyusubov.musicserver.domain.model.Playlist

interface PlaylistsRepository {

    suspend fun getPlaylists(
        userId: Int
    ): List<Playlist>

    suspend fun createPlaylist(
        userId: Int,
        title: String,
        description: String?
    )

    suspend fun deletePlaylist(
        playlistId: Int
    )

    suspend fun addTrackToPlaylist(
        playlistId: Int,
        trackId: Int
    )

    suspend fun removeTrackFromPlaylist(
        playlistId: Int,
        trackId: Int
    )
}