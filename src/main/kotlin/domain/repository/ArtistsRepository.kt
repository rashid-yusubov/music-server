package com.rashidyusubov.musicserver.domain.repository

import com.rashidyusubov.musicserver.domain.model.Album
import com.rashidyusubov.musicserver.domain.model.Artist
import com.rashidyusubov.musicserver.domain.model.Track

interface ArtistsRepository {

    suspend fun getArtists(): List<Artist>

    suspend fun getArtistById(id: Int): Artist?

    suspend fun getArtistTracks(artistId: Int): List<Track>

    suspend fun getArtistAlbums(artistId: Int): List<Album>
}