package com.github.insanusmokrassar.AQICNAPI

val GOOD_LEVEL = 0 .. 50
val ACCEPTABLE_LEVEL = 51 .. 100
val WARNING_LEVEL = 101 .. 150
val DANGER_LEVEL = 151 .. 200
val EMERGENCY_LEVEL = 201 .. 300
val HAZARD_LEVEL = 301 .. Int.MAX_VALUE

private val levelsList = listOf(
    GOOD_LEVEL,
    ACCEPTABLE_LEVEL,
    WARNING_LEVEL,
    DANGER_LEVEL,
    EMERGENCY_LEVEL,
    HAZARD_LEVEL
)

fun aqiLevel(aqi: Int) = levelsList.indexOfFirst {
    aqi in it
}
