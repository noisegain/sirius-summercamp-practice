package com.noisegain.siriuspractice.domain.interactor

import com.noisegain.siriuspractice.domain.model.Trip
import com.noisegain.siriuspractice.domain.repository.TripsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TripsInteractor @Inject constructor(
    private val repository: TripsRepository
) {
    suspend fun getTrips(): List<Trip> {
        return repository.getTrips()
    }
}