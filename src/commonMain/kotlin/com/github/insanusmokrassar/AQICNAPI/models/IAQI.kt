package com.github.insanusmokrassar.AQICNAPI.models

import com.github.insanusmokrassar.AQICNAPI.*
import kotlinx.serialization.*

@Serializable
data class IAQIValue(
    val v: Float
)

@Serializable
data class IAQI(
    @Optional
    val co: IAQIValue? = null,
    @Optional
    val no2: IAQIValue? = null,
    @Optional
    val o3: IAQIValue? = null,
    @Optional
    val p: IAQIValue? = null,
    @Optional
    val pm10: IAQIValue? = null,
    @Optional
    val pm25: IAQIValue? = null,
    @Optional
    val so2: IAQIValue? = null,
    @Optional
    val w: IAQIValue? = null
) {
    @Transient
    val toMapWithoutNulls: Map<String, Float> by lazy {
        listOf(
            CO to co ?.v,
            NO2 to no2 ?.v,
            O3 to o3 ?.v,
            P to p ?.v,
            Pm10 to pm10 ?.v,
            Pm25 to pm25 ?.v,
            SO2 to so2 ?.v,
            W to w ?.v
        ).mapNotNull {
            it.second ?.let { value ->
                it.first to value
            }
        }.toMap()
    }
}
