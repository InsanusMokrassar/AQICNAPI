package com.github.insanusmokrassar.AQICNAPI.models

import com.github.insanusmokrassar.AQICNAPI.Pm25
import com.github.insanusmokrassar.AQICNAPI.aqiLevel
import com.github.insanusmokrassar.AQICNAPI.models.attribution.Attribution
import kotlinx.serialization.*

@Serializable
data class StationData(
    private val idx: Int,
    @SerialName("aqi")
    private val rawAQI: String,
    val time: Time,
    val city: City,
    @Optional
    val attributions: List<Attribution> = emptyList(),
    @Optional
    val iaqi: IAQI = IAQI(),
    @SerialName("dominentpol")
    @Optional
    private val mainAQIValue: String = Pm25
) {
    @Transient
    val cityIdentifier: CityIdentifier = CityIdentifierId(idx)

    @Transient
    val aqi: Int? = rawAQI.toIntOrNull()

    @Transient
    val warningLevel = aqi ?.let { aqiLevel(it) }
}