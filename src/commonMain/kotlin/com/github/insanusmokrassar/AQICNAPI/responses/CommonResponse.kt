package com.github.insanusmokrassar.AQICNAPI.responses

import com.github.insanusmokrassar.AQICNAPI.models.AQIData
import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable

@Serializable
data class CommonResponse(
    val status: String,
    @Optional
    val data: AQIData? = null
)
