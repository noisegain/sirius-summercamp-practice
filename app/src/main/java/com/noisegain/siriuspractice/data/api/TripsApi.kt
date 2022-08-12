package com.noisegain.siriuspractice.data.api

import com.noisegain.siriuspractice.data.model.response.TripsResponse
import retrofit2.http.GET

interface TripsApi {
    @GET("trips")
    suspend fun getTrips(): TripsResponse
}