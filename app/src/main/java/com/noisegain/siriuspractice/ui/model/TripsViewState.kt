package com.noisegain.siriuspractice.ui.model

import com.noisegain.siriuspractice.domain.model.Trip

sealed class TripsViewState {
    object Loading : TripsViewState()
    object Error : TripsViewState()
    data class Display(
        val items: List<Trip> = listOf()
    ) : TripsViewState()
}