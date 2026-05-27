package com.rashidyusubov.musicserver.data.database.tables

import org.jetbrains.exposed.sql.Table

object TracksTable : Table("tracks") {

    val id = integer("id").autoIncrement()

    val title = varchar("title", 255)

    val artistId = reference("artist_id", ArtistsTable.id)

    val albumId = reference("album_id", AlbumsTable.id)

    val duration = integer("duration")

    val genre = varchar("genre", 100)

    val audioUrl = varchar("audio_url", 512)

    val coverUrl = varchar("cover_url", 512)
        .nullable()

    override val primaryKey = PrimaryKey(id)
}