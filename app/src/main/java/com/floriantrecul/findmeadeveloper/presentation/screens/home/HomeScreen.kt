package com.floriantrecul.findmeadeveloper.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.floriantrecul.findmeadeveloper.R
import com.floriantrecul.findmeadeveloper.presentation.components.ProgressBar
import com.floriantrecul.findmeadeveloper.presentation.components.SearchBar
import com.floriantrecul.findmeadeveloper.presentation.components.ToolbarAppBar
import com.floriantrecul.findmeadeveloper.presentation.screens.home.components.ProfileCard
import com.floriantrecul.findmeadeveloper.presentation.screens.home.components.ProfileEmpty
import com.floriantrecul.findmeadeveloper.presentation.screens.home.components.ProfileError
import com.floriantrecul.findmeadeveloper.util.Constants.SIDE_EFFECTS_KEY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

@Composable
fun HomeScreen(
    state: HomeContract.State,
    effectFlow: Flow<HomeContract.Effect>?,
    onActionSent: (event: HomeContract.Action) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val searchTextState = viewModel.viewState.value.searchText

    LaunchedEffect(SIDE_EFFECTS_KEY) {
        effectFlow?.onEach { effect ->
            when (effect) {
                is HomeContract.Effect.DataWasLoaded -> {}
            }
        }?.collect()
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            ToolbarAppBar(
                title = R.string.toolbar_title,
                color = MaterialTheme.colors.primaryVariant
            )
        },
        content = {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                SearchBar(
                    text = searchTextState,
                    onTextChange = {
                        onActionSent(HomeContract.Action.SearchText(searchText = it))
                    },
                    onSearchClicked = {
                        onActionSent(HomeContract.Action.GetProfileWithRepositories)
                    }
                )
                when {
                    state.isEmpty -> ProfileEmpty(
                        image = R.drawable.inspectocat,
                        text = R.string.message_search
                    )
                    state.isLoading -> ProgressBar()
                    state.isError -> {
                        when (state.isError) {
                            true -> {
                                if (state.titleError == null || state.messageError == null) return@Scaffold
                                ProfileError(
                                    image = R.drawable.constructocat2,
                                    text = state.messageError
                                )
                            }
                            false -> Unit
                        }
                    }
                    else -> {
                        state.profile?.let { profile ->
                            Timber.d("profile $profile")
                            ProfileCard(profile = profile, repositories = state.repositories)
                            Timber.d("profile repositories ${state.repositories}")
                        }
                    }
                }
            }
        }
    )
}