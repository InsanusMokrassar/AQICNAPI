package com.github.insanusmokrassar.AQICNAPI.models

import kotlinx.serialization.*

@Serializable(CityIdentifierSerializer::class)
sealed class CityIdentifier {
    abstract val city: String
}

/**
 * cityName must look like beijing
 */
data class CityIdentifierName(
    val cityName: String
) : CityIdentifier() {
    override val city: String = cityName
}

/**
 * id must look like @9999
 */
data class CityIdentifierId(
    val id: String
) : CityIdentifier() {
    override val city: String = id

    constructor(id: Int) : this("@$id")
}

@Serializer(CityIdentifier::class)
object CityIdentifierSerializer : KSerializer<CityIdentifier> {
    override fun serialize(encoder: Encoder, obj: CityIdentifier) {
        encoder.encodeString(obj.city)
    }

    override fun deserialize(decoder: Decoder): CityIdentifier {
        val city: String = decoder.decodeString()
        return when {
            city.startsWith("@") -> CityIdentifierId(city)
            else -> CityIdentifierName(city)
        }
    }
}

