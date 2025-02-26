package com.sunnyweather.android.logic.model

import com.google.gson.annotations.SerializedName

/**
 * @author shiningYang
 * @date 2025-02-26-21:05
 * @description:
 */
class PlaceResponse(val status: String, val places: List<Place>)

data class Place(val name: String, val location: Location, @SerializedName("formatted_address") val address: String)

data class Location(val lng: String, val lat: String)