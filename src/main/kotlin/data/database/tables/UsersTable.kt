package com.rashidyusubov.musicserver.data.database.tables

import org.jetbrains.exposed.sql.Table

object UsersTable : Table("users") {

    val id = integer("id").autoIncrement()

    val firebaseUid = varchar("firebase_uid", 128)

    val email = varchar("email", 255)

    val username = varchar("username", 100)

    val avatarUrl = varchar("avatar_url", 512)
        .nullable()

    override val primaryKey = PrimaryKey(id)
}