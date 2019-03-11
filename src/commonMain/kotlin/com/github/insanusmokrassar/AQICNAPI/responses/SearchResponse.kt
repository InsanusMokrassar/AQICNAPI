package com.github.insanusmokrassar.AQICNAPI.responses

import com.github.insanusmokrassar.AQICNAPI.models.AQIData
import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponse(
    val status: String,
    @Optional
    val data: List<AQIData> = emptyList()
)
