package com.rashidyusubov.musicserver.data.repository

import com.rashidyusubov.musicserver.data.database.tables.TracksTable
import com.rashidyusubov.musicserver.data.mapper.toTrack
import com.rashidyusubov.musicserver.domain.model.Track
import com.rashidyusubov.musicserver.domain.repository.TracksRepository
import org.jetbrains.exposed.sql.SqlExpressionBuilder.like
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class TracksRepositoryImpl : TracksRepository {

    override suspend fun getAllTracks(): List<Track> {

        return transaction {

            TracksTable
                .selectAll()
                .map { it.toTrack() }
        }
    }

    override suspend fun getTrackById(id: Int): Track? {

        return transaction {

            TracksTable
                .selectAll()
                .where {
                    TracksTable.id eq id
                }
                .map { it.toTrack() }
                .singleOrNull()
        }
    }

    override suspend fun searchTracks(query: String): List<Track> {

        return transaction {

            TracksTable
                .selectAll()
                .where {
                    TracksTable.title like "%$query%"
                }
                .map { it.toTrack() }
        }
    }
}