package com.github.insanusmokrassar.AQICNAPI.models

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable

@Serializable
data class Time(
    val s: String,
    val tz: String,
    @Optional
    val v: Long? = null
)
