package com.rashidyusubov.musicserver.data.mapper

import com.rashidyusubov.musicserver.data.database.tables.UsersTable
import com.rashidyusubov.musicserver.domain.model.User
import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.toUser(): User {

    return User(
        id = this[UsersTable.id],
        firebaseUid = this[UsersTable.firebaseUid],
        email = this[UsersTable.email],
        username = this[UsersTable.username],
        avatarUrl = this[UsersTable.avatarUrl]
    )
}