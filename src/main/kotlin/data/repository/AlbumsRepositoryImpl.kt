package com.rashidyusubov.musicserver.data.repository

import com.rashidyusubov.musicserver.data.database.tables.AlbumsTable
import com.rashidyusubov.musicserver.data.database.tables.TracksTable
import com.rashidyusubov.musicserver.data.mapper.toAlbum
import com.rashidyusubov.musicserver.data.mapper.toTrack
import com.rashidyusubov.musicserver.domain.model.Album
import com.rashidyusubov.musicserver.domain.model.Track
import com.rashidyusubov.musicserver.domain.repository.AlbumsRepository
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class AlbumsRepositoryImpl : AlbumsRepository {

    override suspend fun getAlbums(): List<Album> {

        return transaction {

            AlbumsTable
                .selectAll()
                .map { it.toAlbum() }
        }
    }

    override suspend fun getAlbumById(id: Int): Album? {

        return transaction {

            AlbumsTable
                .selectAll()
                .where { AlbumsTable.id eq id }
                .map { it.toAlbum() }
                .singleOrNull()
        }
    }

    override suspend fun getAlbumTracks(albumId: Int): List<Track> {

        return transaction {

            TracksTable
                .selectAll()
                .where { TracksTable.albumId eq albumId }
                .map { it.toTrack() }
        }
    }
}