package com.github.insanusmokrassar.AQICNAPI.models

import com.github.insanusmokrassar.AQICNAPI.*
import com.github.insanusmokrassar.AQICNAPI.models.attribution.Attribution
import kotlinx.serialization.*

@Serializable
data class AQIData(
    @Optional
    private val uid: Int? = null,
    @Optional
    private val idx: Int? = null,
    @SerialName("aqi")
    private val rawAQI: String,
    val time: Time,
    @SerialName("station")
    @Optional
    private val rawStation: Station? = null,
    @SerialName("city")
    @Optional
    private val rawCity: Station? = null,
    @Optional
    val attributions: List<Attribution> = emptyList(),
    @Optional
    val iaqi: IAQI = IAQI(),
    @SerialName("dominentpol")
    @Optional
    private val dominentpol: String = Pm25
) {
    @Transient
    val stationIdentifier: StationIdentifier = StationIdentifierId(uid ?: idx ?: throw IllegalStateException("One of id must be used"))

    @Transient
    val mainAQIField: String = if (dominentpol !in knownTypesOfIAQI || dominentpol !in iaqi.toMapWithoutNulls.keys) {
        iaqi.toMapWithoutNulls.maxBy {
            it.value
        } ?.key ?: dominentpol
    } else {
        dominentpol
    }

    @Transient
    val mainAQIProperty: Pair<String, Float> = mainAQIField to (iaqi.toMapWithoutNulls[mainAQIField] ?: 0F)

    @Transient
    val aqi: Int = rawAQI.toIntOrNull() ?: mainAQIProperty.second.toInt()

    @Transient
    val warningLevel = aqiLevel(aqi)

    @Transient
    val station: Station = rawStation ?: rawCity ?: throw IllegalStateException("One of station fields must be used")
}