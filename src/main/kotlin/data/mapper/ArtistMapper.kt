package com.rashidyusubov.musicserver.data.mapper

import com.rashidyusubov.musicserver.data.database.tables.ArtistsTable
import com.rashidyusubov.musicserver.domain.model.Artist
import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.toArtist(): Artist {

    return Artist(
        id = this[ArtistsTable.id],
        name = this[ArtistsTable.name],
        avatarUrl = this[ArtistsTable.avatarUrl],
        description = this[ArtistsTable.description]
    )
}