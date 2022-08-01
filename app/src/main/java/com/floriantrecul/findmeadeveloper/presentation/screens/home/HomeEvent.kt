package com.floriantrecul.findmeadeveloper.presentation.screens.home

sealed class HomeEvent {
    data class GetProfile(val profileUsername: String): HomeEvent()
}
