package com.floriantrecul.findmeadeveloper.presentation.screens.home

import androidx.lifecycle.viewModelScope
import com.floriantrecul.findmeadeveloper.BaseViewModel
import com.floriantrecul.findmeadeveloper.domain.use_case.ProfileUsesCases
import com.floriantrecul.findmeadeveloper.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val profileUsesCases: ProfileUsesCases
) : BaseViewModel<HomeContract.Action, HomeContract.State, HomeContract.Effect>() {

    override fun setInitialState() = HomeContract.State(
        isEmpty = true,
        isLoading = false,
        searchText = "",
        profile = null,
        repositories = emptyList(),
        isError = false,
        titleError = null,
        messageError = null,
    )

    override fun handleActions(action: HomeContract.Action) {

        when (action) {
            is HomeContract.Action.SearchText -> updateSearchTextState(action.searchText)
            is HomeContract.Action.GetProfileWithRepositories -> getProfileWithRepositories()
        }
    }

    private fun updateSearchTextState(searchText: String) {
        setState {
            copy(
                isEmpty = true,
                isLoading = false,
                profile = null,
                searchText = searchText,
                isError = false
            )
        }
    }

    private fun getProfileWithRepositories() = viewModelScope.launch(Dispatchers.IO) {
        getProfile()
        getRepositories()
    }

    private suspend fun getProfile() {
        profileUsesCases.getProfile(profileUsername = viewState.value.searchText)
            .onEach { result ->
                when (result) {
                    is Result.Empty -> setState {
                        copy(
                            isEmpty = true,
                            isLoading = false,
                            isError = false
                        )
                    }
                    is Result.Loading -> setState {
                        copy(
                            isEmpty = false,
                            isLoading = true,
                            isError = false
                        )
                    }
                    is Result.Success -> {
                        setState {
                            copy(
                                isEmpty = false,
                                isLoading = false,
                                profile = result.data,
                                isError = false
                            )
                        }
                        setEffect { HomeContract.Effect.DataWasLoaded }
                    }
                    is Result.Error -> setState {
                        copy(
                            isEmpty = false,
                            isError = true,
                            isLoading = false,
                            titleError = result.title,
                            messageError = result.message
                        )
                    }
                }
            }
            .launchIn(viewModelScope)
    }

    private suspend fun getRepositories() {
        profileUsesCases.getRepositories(profileUsername = viewState.value.searchText)
            .onEach { result ->
                when (result) {
                    is Result.Empty -> setState {
                        copy(
                            isEmpty = true,
                            isLoading = false,
                            isError = false
                        )
                    }
                    is Result.Loading -> setState {
                        copy(
                            isEmpty = false,
                            isLoading = true,
                            isError = false
                        )
                    }
                    is Result.Success -> {
                        setState {
                            copy(
                                isEmpty = false,
                                isLoading = false,
                                repositories = result.data,
                                isError = false
                            )
                        }
                        setEffect { HomeContract.Effect.DataWasLoaded }
                    }
                    else -> Unit
                }
            }
            .launchIn(viewModelScope)
    }

}