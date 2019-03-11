package com.github.insanusmokrassar.AQICNAPI.responses

import com.github.insanusmokrassar.AQICNAPI.models.MapLocation
import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable

@Serializable
data class OnMapResponse(
    val status: String,
    @Optional
    val data: List<MapLocation> = emptyList()
)
