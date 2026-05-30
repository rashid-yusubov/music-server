package com.rashidyusubov.musicserver.data.repository

import com.rashidyusubov.musicserver.data.database.tables.PlaylistTracksTable
import com.rashidyusubov.musicserver.data.database.tables.PlaylistsTable
import com.rashidyusubov.musicserver.domain.model.Playlist
import com.rashidyusubov.musicserver.domain.repository.PlaylistsRepository
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import com.rashidyusubov.musicserver.data.database.tables.TracksTable
import com.rashidyusubov.musicserver.domain.model.Track
import org.jetbrains.exposed.sql.select

class PlaylistsRepositoryImpl : PlaylistsRepository {

    override suspend fun getPlaylists(
        userId: Int
    ): List<Playlist> {

        return transaction {

            PlaylistsTable
                .selectAll()
                .where {
                    PlaylistsTable.userId eq userId
                }
                .map {

                    Playlist(
                        id = it[PlaylistsTable.id],
                        userId = it[PlaylistsTable.userId],
                        title = it[PlaylistsTable.title],
                        description = it[PlaylistsTable.description],
                        coverUrl = it[PlaylistsTable.coverUrl]
                    )
                }
        }
    }

    override suspend fun createPlaylist(
        userId: Int,
        title: String,
        description: String?
    ) {

        transaction {

            PlaylistsTable.insert {

                it[PlaylistsTable.userId] = userId

                it[PlaylistsTable.title] = title

                it[PlaylistsTable.description] = description

                it[coverUrl] = null
            }
        }
    }

    override suspend fun deletePlaylist(
        playlistId: Int
    ) {

        transaction {

            PlaylistTracksTable.deleteWhere {

                PlaylistTracksTable.playlistId eq playlistId
            }

            PlaylistsTable.deleteWhere {

                PlaylistsTable.id eq playlistId
            }
        }
    }

    override suspend fun addTrackToPlaylist(
        playlistId: Int,
        trackId: Int
    ) {

        transaction {

            PlaylistTracksTable.insert {

                it[PlaylistTracksTable.playlistId] = playlistId

                it[PlaylistTracksTable.trackId] = trackId
            }
        }
    }

    override suspend fun removeTrackFromPlaylist(
        playlistId: Int,
        trackId: Int
    ) {

        transaction {

            PlaylistTracksTable.deleteWhere {

                (PlaylistTracksTable.playlistId eq playlistId) and
                        (PlaylistTracksTable.trackId eq trackId)
            }
        }
    }

    override suspend fun getPlaylistTracks(
        playlistId: Int
    ): List<Track> {

        return transaction {

            (PlaylistTracksTable innerJoin TracksTable)
                .select(
                    TracksTable.columns
                )
                .where {
                    PlaylistTracksTable.playlistId eq playlistId
                }
                .map {

                    Track(
                        id = it[TracksTable.id],
                        title = it[TracksTable.title],
                        artistId = it[TracksTable.artistId],
                        albumId = it[TracksTable.albumId],
                        duration = it[TracksTable.duration],
                        genre = it[TracksTable.genre],
                        audioUrl = it[TracksTable.audioUrl],
                        coverUrl = it[TracksTable.coverUrl]
                    )
                }
        }
    }
}