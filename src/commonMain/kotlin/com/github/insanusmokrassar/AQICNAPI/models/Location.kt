package com.github.insanusmokrassar.AQICNAPI.models

import kotlinx.serialization.Serializable

@Serializable
data class Location (
    val lat: Double,
    val lon: Double
)
