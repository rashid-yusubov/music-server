package com.rashidyusubov.musicserver.data.database

import com.rashidyusubov.musicserver.data.database.tables.AlbumsTable
import com.rashidyusubov.musicserver.data.database.tables.ArtistsTable
import com.rashidyusubov.musicserver.data.database.tables.TracksTable
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseSeeder {

    fun seed() {

        transaction {

            val hasTracks = TracksTable
                .selectAll()
                .count() > 0

            if (hasTracks) return@transaction

            ArtistsTable.insert {

                it[name] = "Imagine Dragons"

                it[avatarUrl] = null

                it[description] = "American pop rock band"
            }

            AlbumsTable.insert {

                it[title] = "Evolve"

                it[artistId] = 1

                it[coverUrl] = null

                it[releaseYear] = 2017
            }

            TracksTable.insert {

                it[title] = "Believer"

                it[artistId] = 1

                it[albumId] = 1

                it[duration] = 204

                it[genre] = "Rock"

                it[audioUrl] = "/audio/believer.mp3"

                it[coverUrl] = null
            }

            TracksTable.insert {

                it[title] = "Thunder"

                it[artistId] = 1

                it[albumId] = 1

                it[duration] = 187

                it[genre] = "Rock"

                it[audioUrl] = "/audio/thunder.mp3"

                it[coverUrl] = null
            }
        }
    }
}