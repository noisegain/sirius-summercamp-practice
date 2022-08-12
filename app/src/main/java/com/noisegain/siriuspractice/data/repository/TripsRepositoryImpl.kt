package com.noisegain.siriuspractice.data.repository

import com.noisegain.siriuspractice.data.api.TripsApi
import com.noisegain.siriuspractice.data.mapper.TripsMapper
import com.noisegain.siriuspractice.domain.model.Trip
import com.noisegain.siriuspractice.domain.repository.TripsRepository
import javax.inject.Inject

class TripsRepositoryImpl @Inject constructor(
    private val api: TripsApi,
    private val mapper: TripsMapper
) : TripsRepository {
    override suspend fun getTrips(): List<Trip> {
        return mapper.map(api.getTrips())
    }
}

