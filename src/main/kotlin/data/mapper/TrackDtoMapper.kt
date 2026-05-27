package com.rashidyusubov.musicserver.data.mapper

import com.rashidyusubov.musicserver.data.dto.TrackResponseDto
import com.rashidyusubov.musicserver.domain.model.Track

fun Track.toResponseDto(): TrackResponseDto {
    return TrackResponseDto(
        id = id,
        title = title,
        artistId = artistId,
        albumId = albumId,
        duration = duration,
        genre = genre,
        audioUrl = audioUrl,
        coverUrl = coverUrl
    )
}