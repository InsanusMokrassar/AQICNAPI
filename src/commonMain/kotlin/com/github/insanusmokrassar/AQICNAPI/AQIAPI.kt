package com.github.insanusmokrassar.AQICNAPI

import com.github.insanusmokrassar.AQICNAPI.models.*
import com.github.insanusmokrassar.AQICNAPI.responses.*
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.Url
import kotlinx.serialization.json.Json

class AQIAPI(
    private val client: HttpClient,
    private val token: String
) {
    private val baseURL: String = "https://api.waqi.info/"

    suspend fun cityAQI(cityIdentifier: CityIdentifier): AQIData? {
        return try {
            client.get<String>(Url("$baseURL${cityFeed(cityIdentifier, token)}")).let {
                Json.nonstrict.parse(CommonResponse.serializer(), it).data
            }
        } catch (e: Exception) {
            println(e.message)
            null
        }
    }

    suspend fun hereAQI(): AQIData? {
        return try {
            client.get<String>(Url("$baseURL${hereFeed(token)}")).let {
                Json.nonstrict.parse(CommonResponse.serializer(), it).data
            }
        } catch (e: Exception) {
            println(e.message)
            null
        }
    }

    suspend fun locationAQI(location: Location): AQIData? {
        return try {
            client.get<String>(Url("$baseURL${locationFeed(location, token)}")).let {
                Json.nonstrict.parse(CommonResponse.serializer(), it).data
            }
        } catch (e: Exception) {
            println(e.message)
            null
        }
    }

    suspend fun mapStations(leftTop: Location, rightBottom: Location): List<MapLocation> {
        return try {
            client.get<String>(Url("$baseURL${onMapFeed(leftTop, rightBottom, token)}")).let {
                Json.nonstrict.parse(OnMapResponse.serializer(), it).data
            }
        } catch (e: Exception) {
            println(e.message)
            emptyList()
        }
    }

    suspend fun search(what: String): List<AQIData> {
        return try {
            client.get<String>(Url("$baseURL${com.github.insanusmokrassar.AQICNAPI.search(what, token)}")).let {
                Json.nonstrict.parse(SearchResponse.serializer(), it).data
            }
        } catch (e: Exception) {
            println(e.message)
            emptyList()
        }
    }
}