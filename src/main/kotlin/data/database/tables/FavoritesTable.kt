package com.rashidyusubov.musicserver.data.database.tables

import org.jetbrains.exposed.sql.Table

object FavoritesTable : Table("favorites") {

    val id = integer("id").autoIncrement()

    val userId = reference("user_id", UsersTable.id)

    val trackId = reference("track_id", TracksTable.id)

    override val primaryKey = PrimaryKey(id)
}