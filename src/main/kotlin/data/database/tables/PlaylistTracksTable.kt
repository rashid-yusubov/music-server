package com.rashidyusubov.musicserver.data.database.tables

import org.jetbrains.exposed.sql.Table

object PlaylistTracksTable : Table("playlist_tracks") {

    val playlistId = reference("playlist_id", PlaylistsTable.id)

    val trackId = reference("track_id", TracksTable.id)

    override val primaryKey = PrimaryKey(
        playlistId,
        trackId
    )
}