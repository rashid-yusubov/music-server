package com.rashidyusubov.musicserver.domain.repository

import com.rashidyusubov.musicserver.domain.model.Album
import com.rashidyusubov.musicserver.domain.model.Track

interface AlbumsRepository {

    suspend fun getAlbums(): List<Album>

    suspend fun getAlbumById(id: Int): Album?

    suspend fun getAlbumTracks(albumId: Int): List<Track>
}