package com.github.insanusmokrassar.AQICNAPI.models

import kotlinx.serialization.*

@Serializable
data class MapLocation(
    val lat: Double,
    val lon: Double,
    val uid: Int,
    @SerialName("aqi")
    private val rawAQI: String
) {
    @Transient
    val aqi: Int? = rawAQI.toIntOrNull()
}
