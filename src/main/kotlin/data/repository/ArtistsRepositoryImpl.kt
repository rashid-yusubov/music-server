package com.rashidyusubov.musicserver.data.repository

import com.rashidyusubov.musicserver.data.database.tables.AlbumsTable
import com.rashidyusubov.musicserver.data.database.tables.ArtistsTable
import com.rashidyusubov.musicserver.data.database.tables.TracksTable
import com.rashidyusubov.musicserver.data.mapper.toAlbum
import com.rashidyusubov.musicserver.data.mapper.toArtist
import com.rashidyusubov.musicserver.data.mapper.toTrack
import com.rashidyusubov.musicserver.domain.model.Album
import com.rashidyusubov.musicserver.domain.model.Artist
import com.rashidyusubov.musicserver.domain.model.Track
import com.rashidyusubov.musicserver.domain.repository.ArtistsRepository
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class ArtistsRepositoryImpl : ArtistsRepository {

    override suspend fun getArtists(): List<Artist> {

        return transaction {

            ArtistsTable
                .selectAll()
                .map { it.toArtist() }
        }
    }

    override suspend fun getArtistById(id: Int): Artist? {

        return transaction {

            ArtistsTable
                .selectAll()
                .where { ArtistsTable.id eq id }
                .map { it.toArtist() }
                .singleOrNull()
        }
    }

    override suspend fun getArtistTracks(artistId: Int): List<Track> {

        return transaction {

            TracksTable
                .selectAll()
                .where { TracksTable.artistId eq artistId }
                .map { it.toTrack() }
        }
    }

    override suspend fun getArtistAlbums(artistId: Int): List<Album> {

        return transaction {

            AlbumsTable
                .selectAll()
                .where { AlbumsTable.artistId eq artistId }
                .map { it.toAlbum() }
        }
    }
}