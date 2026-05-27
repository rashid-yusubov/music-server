package com.rashidyusubov.musicserver.data.database

import com.rashidyusubov.musicserver.data.database.tables.AlbumsTable
import com.rashidyusubov.musicserver.data.database.tables.ArtistsTable
import com.rashidyusubov.musicserver.data.database.tables.FavoritesTable
import com.rashidyusubov.musicserver.data.database.tables.PlaylistTracksTable
import com.rashidyusubov.musicserver.data.database.tables.PlaylistsTable
import com.rashidyusubov.musicserver.data.database.tables.TracksTable
import com.rashidyusubov.musicserver.data.database.tables.UsersTable
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.github.cdimascio.dotenv.dotenv
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {

    private val dotenv = dotenv()

    fun init() {

        val config = HikariConfig().apply {

            jdbcUrl = dotenv["DATABASE_URL"]

            driverClassName = "org.postgresql.Driver"

            maximumPoolSize = 10

            isAutoCommit = false

            transactionIsolation = "TRANSACTION_REPEATABLE_READ"

            validate()
        }

        val dataSource = HikariDataSource(config)

        Database.connect(dataSource)

        transaction {

            SchemaUtils.create(
                UsersTable,
                ArtistsTable,
                AlbumsTable,
                TracksTable,
                FavoritesTable,
                PlaylistsTable,
                PlaylistTracksTable
            )
        }
    }
}