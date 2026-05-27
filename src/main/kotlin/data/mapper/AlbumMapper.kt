package com.rashidyusubov.musicserver.data.mapper

import com.rashidyusubov.musicserver.data.database.tables.AlbumsTable
import com.rashidyusubov.musicserver.domain.model.Album
import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.toAlbum(): Album {

    return Album(
        id = this[AlbumsTable.id],
        artistId = this[AlbumsTable.artistId],
        title = this[AlbumsTable.title],
        coverUrl = this[AlbumsTable.coverUrl],
        releaseYear = this[AlbumsTable.releaseYear]
    )
}