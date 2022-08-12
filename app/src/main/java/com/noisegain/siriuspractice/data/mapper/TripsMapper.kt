package com.noisegain.siriuspractice.data.mapper

import com.noisegain.siriuspractice.data.model.response.TripsResponse
import com.noisegain.siriuspractice.domain.model.Trip

interface TripsMapper {
    fun map(response: TripsResponse): List<Trip>
}