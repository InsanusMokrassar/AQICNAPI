package com.github.insanusmokrassar.AQICNAPI.responses

import com.github.insanusmokrassar.AQICNAPI.models.StationData
import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable

@Serializable
data class CommonResponse(
    val status: String,
    @Optional
    val data: StationData? = null
)
