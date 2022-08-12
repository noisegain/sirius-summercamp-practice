package com.noisegain.siriuspractice.data.mapper

import com.noisegain.siriuspractice.data.model.response.TripsResponse
import com.noisegain.siriuspractice.domain.model.Trip
import java.util.*
import javax.inject.Inject

class TripsMapperImpl @Inject constructor() : TripsMapper {
    override fun map(response: TripsResponse) = response.trips.map {
        Trip(
            id = it.id.orEmpty(),
            startLocation = it.startLocation.orEmpty(),
            endLocation = it.endLocation.orEmpty(),
            placesAvailable = it.placesAvailable ?: 0,
            departure = Date(it.departure ?: 0L),
            passengers = it.passengers
        )
    }
}