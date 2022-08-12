package com.noisegain.siriuspractice.domain.repository

import com.noisegain.siriuspractice.domain.model.Trip

interface TripsRepository {
    suspend fun getTrips(): List<Trip>
}