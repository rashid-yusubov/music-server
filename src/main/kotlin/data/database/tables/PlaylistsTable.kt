package com.rashidyusubov.musicserver.data.database.tables

import org.jetbrains.exposed.sql.Table

object PlaylistsTable : Table("playlists") {

    val id = integer("id").autoIncrement()

    val userId = reference("user_id", UsersTable.id)

    val title = varchar("title", 255)

    val description = text("description")
        .nullable()

    val coverUrl = varchar("cover_url", 512)
        .nullable()

    override val primaryKey = PrimaryKey(id)
}