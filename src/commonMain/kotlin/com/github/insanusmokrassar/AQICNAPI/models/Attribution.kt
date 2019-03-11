package com.github.insanusmokrassar.AQICNAPI.models.attribution

import kotlinx.serialization.Serializable

@Serializable
data class Attribution(
    val url: String,
    val name: String
)
