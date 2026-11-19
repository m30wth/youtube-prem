// /youtube-prem/data/model/Video.kt

package com.youtubeprem.data.model

data class Video(
    val id: String,
    val title: String,
    val thumbnailUrl: String,
    val videoUrl: String, // The direct URL to the video stream or download link
    val durationSeconds: Long
)