package com.github.insanusmokrassar.AQICNAPI

import com.github.insanusmokrassar.AQICNAPI.models.CityIdentifier
import com.github.insanusmokrassar.AQICNAPI.models.Location

internal fun cityFeed(cityIdentifier: CityIdentifier, token: String) = "feed/${cityIdentifier.city}/?token=$token"
internal fun hereFeed(token: String) = "feed/here/?token=$token"
internal fun locationFeed(location: Location, token: String) = "feed/geo:${location.lat};${location.lon}/?token=$token"
internal fun onMapFeed(leftTop: Location, rightBottom: Location, token: String) = "map/bounds/?token=$token&latlng=${leftTop.lat},${leftTop.lon},${rightBottom.lat},${rightBottom.lon}"
internal fun search(searchLine: String, token: String) = "search/?token=$token&keyword=$searchLine"
