package com.github.insanusmokrassar.AQICNAPI.models

import kotlinx.serialization.Serializable

@Serializable
data class AQIInformation(
    val aqi: Int
)
