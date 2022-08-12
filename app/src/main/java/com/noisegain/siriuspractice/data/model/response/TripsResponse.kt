package com.noisegain.siriuspractice.data.model.response

import com.google.gson.annotations.SerializedName

class TripsResponse(
    @SerializedName("trips")
    val trips: List<TripResponse>
)