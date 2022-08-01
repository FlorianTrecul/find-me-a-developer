package com.floriantrecul.findmeadeveloper.presentation.screens.home

import com.floriantrecul.findmeadeveloper.ViewAction
import com.floriantrecul.findmeadeveloper.ViewSideEffect
import com.floriantrecul.findmeadeveloper.ViewState
import com.floriantrecul.findmeadeveloper.domain.model.Profile

class HomeContract {

    sealed class Action : ViewAction {
        data class SearchText(val searchText: String) : Action()
        object GetProfile : Action()
    }

    data class State(
        val isEmpty: Boolean,
        val isLoading: Boolean,
        val searchText: String,
        val profile: Profile?,
        val isError: Boolean,
        val titleError: Int?,
        val messageError: Int?
    ) : ViewState


    sealed class Effect : ViewSideEffect {
        object DataWasLoaded : Effect()
    }
}

