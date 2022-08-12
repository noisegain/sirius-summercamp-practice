package com.noisegain.siriuspractice.ui.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.noisegain.siriuspractice.domain.interactor.TripsInteractor
import com.noisegain.siriuspractice.ui.model.TripsViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import okhttp3.Dispatcher
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class TripsViewModel @Inject constructor(
    private val interactor: TripsInteractor
) : ViewModel() {
    private val _tripsViewState: MutableLiveData<TripsViewState> =
        MutableLiveData(TripsViewState.Loading)
    val tripsViewState: LiveData<TripsViewState> = _tripsViewState

    fun consume(/* event */) {
        viewModelScope.launch(
            CoroutineExceptionHandler { coroutineContext, throwable ->
                Log.e("CoroutineError", "Error while getting trips")
                _tripsViewState.value = TripsViewState.Error
                coroutineContext.cancel()
            }) {
            _tripsViewState.value = TripsViewState.Display(interactor.getTrips())
        }
    }
}