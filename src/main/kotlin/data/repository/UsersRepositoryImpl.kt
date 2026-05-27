package com.rashidyusubov.musicserver.data.repository

import com.rashidyusubov.musicserver.data.database.tables.UsersTable
import com.rashidyusubov.musicserver.data.mapper.toUser
import com.rashidyusubov.musicserver.domain.model.User
import com.rashidyusubov.musicserver.domain.repository.UsersRepository
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class UsersRepositoryImpl : UsersRepository {

    override suspend fun getUserByFirebaseUid(
        firebaseUid: String
    ): User? {

        return transaction {

            UsersTable
                .selectAll()
                .where {
                    UsersTable.firebaseUid eq firebaseUid
                }
                .map { it.toUser() }
                .singleOrNull()
        }
    }

    override suspend fun createUser(
        firebaseUid: String,
        email: String
    ): User {

        transaction {

            UsersTable.insert {

                it[UsersTable.firebaseUid] = firebaseUid

                it[UsersTable.email] = email

                it[username] = email.substringBefore("@")

                it[avatarUrl] = null
            }
        }

        return getUserByFirebaseUid(firebaseUid)
            ?: error("User creation failed")
    }
}