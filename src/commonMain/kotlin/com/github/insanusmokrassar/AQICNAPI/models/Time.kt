package com.github.insanusmokrassar.AQICNAPI.models

import kotlinx.serialization.*

@Serializable
data class Time(
    val tz: String,
    @Optional
    val s: String? = null,
    @Optional
    val stime: String? = null,
    @Optional
    val vtime: Long? = null,
    @Optional
    val v: Long? = null
) {
    @Transient
    val timeString: String? = s ?: stime
    @Transient
    val timeSeconds: Long? = v ?: vtime
}
