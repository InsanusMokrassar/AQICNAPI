package com.github.insanusmokrassar.AQICNAPI.models

import kotlinx.serialization.*

@Serializable
data class City(
    @SerialName("name")
    val stationName: String,
    val url: String,
    private val geo: List<String>
) {
    @Transient
    val location: Location by lazy {
        Location(
            geo[0].toDouble(),
            geo[1].toDouble()
        )
    }
}