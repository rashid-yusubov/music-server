package com.rashidyusubov.musicserver.data.mapper

import com.rashidyusubov.musicserver.data.database.tables.TracksTable
import com.rashidyusubov.musicserver.domain.model.Track
import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.toTrack(): Track {
    return Track(
        id = this[TracksTable.id],
        title = this[TracksTable.title],
        artistId = this[TracksTable.artistId],
        albumId = this[TracksTable.albumId],
        duration = this[TracksTable.duration],
        genre = this[TracksTable.genre],
        audioUrl = this[TracksTable.audioUrl],
        coverUrl = this[TracksTable.coverUrl]
    )
}