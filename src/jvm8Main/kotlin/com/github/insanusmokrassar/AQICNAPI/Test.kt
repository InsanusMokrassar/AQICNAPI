package com.github.insanusmokrassar.AQICNAPI

import com.github.insanusmokrassar.AQICNAPI.models.CityIdentifierName
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import kotlinx.coroutines.runBlocking
import java.util.*

fun main(vararg args: String) {
    val api = AQIAPI(
        HttpClient(OkHttp.create()),
        args.first()
    )
    val scanner = Scanner(System.`in`)
    while (true) {
        val city = scanner.nextLine()
        runBlocking {
            api.cityAQI(CityIdentifierName(city)) ?.let {
                println("AQI: ${it.aqi}\nMain property: ${it.mainAQIField}\nMain value: ${it.mainAQIProperty.second}")
            }
        }
    }
}
