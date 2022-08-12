package com.floriantrecul.findmeadeveloper.presentation.screens.home

import com.floriantrecul.findmeadeveloper.ViewAction
import com.floriantrecul.findmeadeveloper.ViewSideEffect
import com.floriantrecul.findmeadeveloper.ViewState
import com.floriantrecul.findmeadeveloper.domain.model.Profile
import com.floriantrecul.findmeadeveloper.domain.model.Repository

class HomeContract {

    sealed class Action : ViewAction {
        data class SearchText(val searchText: String) : Action()
        object GetProfile : Action()
        object GetRepositories : Action()
    }

    data class State(
        val isEmpty: Boolean,
        val isLoading: Boolean,
        val searchText: String,
        val profile: Profile?,
        val repositories: List<Repository>,
        val isError: Boolean,
        val titleError: Int?,
        val messageError: Int?
    ) : ViewState


    sealed class Effect : ViewSideEffect {
        object DataWasLoaded : Effect()
    }
}

