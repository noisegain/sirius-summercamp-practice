package com.noisegain.siriuspractice.data.model.response

import com.google.gson.annotations.SerializedName

class TripResponse(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("startLocation")
    val startLocation: String? = null,
    @SerializedName("endLocation")
    val endLocation: String? = null,
    @SerializedName("placesAvailable")
    val placesAvailable: Int? = null,
    @SerializedName("departure")
    val departure: Long? = null,
    @SerializedName("passengers")
    val passengers: List<String> = listOf()
)