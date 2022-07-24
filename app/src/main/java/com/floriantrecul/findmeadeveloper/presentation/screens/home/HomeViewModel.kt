package com.floriantrecul.findmeadeveloper.presentation.screens.home

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _searchTextState: MutableState<String> = mutableStateOf(value = "")
    val searchTextState: State<String> = _searchTextState

    fun updateSearchTextState(newValue: String) {
        _searchTextState.value = newValue
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.GetProfile -> {
                Log.d("Searched Text", event.profileUserName)
                updateSearchTextState("")
            }
        }
    }

}