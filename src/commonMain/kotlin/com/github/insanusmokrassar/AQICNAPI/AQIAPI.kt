package com.github.insanusmokrassar.AQICNAPI

import com.github.insanusmokrassar.AQICNAPI.models.*
import com.github.insanusmokrassar.AQICNAPI.responses.*
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.Url

class AQIAPI(
    private val client: HttpClient,
    private val token: String
) {
    private val baseURL: String = "https://api.waqi.info/"

    suspend fun cityAQI(cityIdentifier: CityIdentifier): StationData? {
        return try {
            client.get<CommonResponse>(Url("$baseURL${cityFeed(cityIdentifier, token)}")).data
        } catch (e: Exception) {
            println(e.message)
            null
        }
    }

    suspend fun hereAQI(): StationData? {
        return try {
            client.get<CommonResponse>(Url("$baseURL${hereFeed(token)}")).data
        } catch (e: Exception) {
            println(e.message)
            null
        }
    }

    suspend fun locationAQI(location: Location): StationData? {
        return try {
            client.get<CommonResponse>(Url("$baseURL${locationFeed(location, token)}")).data
        } catch (e: Exception) {
            println(e.message)
            null
        }
    }

    suspend fun mapStations(leftTop: Location, rightBottom: Location): List<MapLocation> {
        return try {
            client.get<OnMapResponse>(Url("$baseURL${onMapFeed(leftTop, rightBottom, token)}")).data
        } catch (e: Exception) {
            println(e.message)
            emptyList()
        }
    }

    suspend fun search(what: String): List<StationData> {
        return try {
            client.get<SearchResponse>(Url("$baseURL${com.github.insanusmokrassar.AQICNAPI.search(what, token)}")).data
        } catch (e: Exception) {
            println(e.message)
            emptyList()
        }
    }
}