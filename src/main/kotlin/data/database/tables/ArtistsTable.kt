package com.rashidyusubov.musicserver.data.database.tables

import org.jetbrains.exposed.sql.Table

object ArtistsTable : Table("artists") {

    val id = integer("id").autoIncrement()

    val name = varchar("name", 255)

    val avatarUrl = varchar("avatar_url", 512)
        .nullable()

    val description = text("description")
        .nullable()

    override val primaryKey = PrimaryKey(id)
}