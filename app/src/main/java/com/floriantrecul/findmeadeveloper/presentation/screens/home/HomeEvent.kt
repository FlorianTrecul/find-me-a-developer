package com.floriantrecul.findmeadeveloper.presentation.screens.home

sealed class HomeEvent {
    data class GetProfile(val profileUserName: String): HomeEvent()
}
