package com.rashidyusubov.musicserver.data.repository

import com.rashidyusubov.musicserver.data.database.tables.FavoritesTable
import com.rashidyusubov.musicserver.data.database.tables.TracksTable
import com.rashidyusubov.musicserver.data.mapper.toTrack
import com.rashidyusubov.musicserver.domain.model.Track
import com.rashidyusubov.musicserver.domain.repository.FavoritesRepository
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class FavoritesRepositoryImpl : FavoritesRepository {

    override suspend fun getFavorites(
        userId: Int
    ): List<Track> {

        return transaction {

            (FavoritesTable innerJoin TracksTable)
                .selectAll()
                .where {
                    FavoritesTable.userId eq userId
                }
                .map { it.toTrack() }
        }
    }

    override suspend fun addToFavorites(
        userId: Int,
        trackId: Int
    ) {

        transaction {

            FavoritesTable.insert {

                it[FavoritesTable.userId] = userId

                it[FavoritesTable.trackId] = trackId
            }
        }
    }

    override suspend fun removeFromFavorites(
        userId: Int,
        trackId: Int
    ) {

        transaction {

            FavoritesTable.deleteWhere {

                (FavoritesTable.userId eq userId) and
                        (FavoritesTable.trackId eq trackId)
            }
        }
    }
}