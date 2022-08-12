package com.noisegain.siriuspractice.domain.model

import java.util.*

data class Trip(
    val id: String,
    val startLocation: String,
    val endLocation: String,
    val placesAvailable: Int,
    val departure: Date,
    val passengers: List<String>
)