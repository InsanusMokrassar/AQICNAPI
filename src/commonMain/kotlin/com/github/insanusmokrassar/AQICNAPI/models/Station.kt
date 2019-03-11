package com.github.insanusmokrassar.AQICNAPI.models

import kotlinx.serialization.*

@Serializable
data class Station(
    val name: String,
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