package com.noisegain.siriuspractice.ui.kit

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.noisegain.siriuspractice.domain.model.Trip
import com.noisegain.siriuspractice.ui.model.TripsViewState
import com.noisegain.siriuspractice.ui.theme.Blue200
import com.noisegain.siriuspractice.ui.theme.Typography
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun Trip(trip: Trip) {
    Row(Modifier.padding(16.dp)) {
        Column {
            Text("Поездка ${trip.id}", style = Typography.h2)
            LeftRightText("Старт", trip.startLocation)
            LeftRightText("Назначение", trip.endLocation)
            LeftRightText("Свободных мест", trip.placesAvailable.toString())
            LeftRightText("Отправление", SimpleDateFormat("HH:mm").format(trip.departure))
            Row(
                modifier = Modifier.fillMaxWidth(),
                Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Пассажиры", style = Typography.body1, textAlign = TextAlign.Left)
                Row {
                    trip.passengers.forEach {
                        Spacer(modifier = Modifier.size(4.dp))
                        AsyncImage(
                            model = it, contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(32.dp)
                                .clip(CircleShape)
                                .border(2.dp, Blue200, CircleShape)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun LeftRightText(text1: String, text2: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text1, style = Typography.body1, textAlign = TextAlign.Left)
        Text(text2, style = Typography.h3, textAlign = TextAlign.Right)
    }
}

@Preview(showBackground = true)
@Composable
fun ShowTrip() {
    Trip(Trip("aboba", "sirius", "mama", 3, Date(123123), listOf("aboba")))
}

@Composable
fun Trips(trips: List<Trip>) {
    LazyColumn {
        items(trips) {
            Trip(it)
        }
    }
}

@Composable
fun TripsScreen(state: State<TripsViewState>) {
    when (val data = state.value) {
        is TripsViewState.Display -> Trips(data.items)
        TripsViewState.Error -> Text("ERROR")
        TripsViewState.Loading -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}