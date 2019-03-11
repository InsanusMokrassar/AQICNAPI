package com.github.insanusmokrassar.AQICNAPI.models

import kotlinx.serialization.*

@Serializable(StationIdentifierSerializer::class)
sealed class StationIdentifier {
    abstract val station: String
}

/**
 * cityName must look like beijing
 */
data class StationIdentifierName(
    val cityName: String
) : StationIdentifier() {
    override val station: String = cityName
}

/**
 * id must look like @9999
 */
data class StationIdentifierId(
    val id: String
) : StationIdentifier() {
    override val station: String = id

    constructor(id: Int) : this("@$id")
}

@Serializer(StationIdentifier::class)
object StationIdentifierSerializer : KSerializer<StationIdentifier> {
    override fun serialize(encoder: Encoder, obj: StationIdentifier) {
        encoder.encodeString(obj.station)
    }

    override fun deserialize(decoder: Decoder): StationIdentifier {
        val station: String = decoder.decodeString()
        return when {
            station.startsWith("@") -> StationIdentifierId(station)
            else -> StationIdentifierName(station)
        }
    }
}

