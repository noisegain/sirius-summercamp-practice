package com.noisegain.siriuspractice.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.noisegain.siriuspractice.ui.kit.TripsScreen
import com.noisegain.siriuspractice.ui.model.TripsViewState
import com.noisegain.siriuspractice.ui.theme.SiriusPracticeTheme
import com.noisegain.siriuspractice.ui.viewmodel.TripsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val tripsVM: TripsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SiriusPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) { MainScreen() }
            }
        }
        tripsVM.consume()
    }

    @Composable
    private fun MainScreen() {
        TripsScreen(state = tripsVM.tripsViewState.observeAsState(initial = TripsViewState.Loading))
    }
}