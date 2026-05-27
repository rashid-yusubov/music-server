package com.rashidyusubov.musicserver.data.database.tables

import org.jetbrains.exposed.sql.Table

object AlbumsTable : Table("albums") {

    val id = integer("id").autoIncrement()

    val title = varchar("title", 255)

    val artistId = reference("artist_id", ArtistsTable.id)

    val coverUrl = varchar("cover_url", 512)
        .nullable()

    val releaseYear = integer("release_year")

    override val primaryKey = PrimaryKey(id)
}