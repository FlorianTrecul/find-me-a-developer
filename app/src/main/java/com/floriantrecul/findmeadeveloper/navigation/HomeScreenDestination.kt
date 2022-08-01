package com.floriantrecul.findmeadeveloper.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.floriantrecul.findmeadeveloper.presentation.screens.home.HomeScreen
import com.floriantrecul.findmeadeveloper.presentation.screens.home.HomeViewModel

@Composable
fun HomeScreenDestination(
    viewModel: HomeViewModel = hiltViewModel()
) {
    HomeScreen(
        state = viewModel.viewState.value,
        effectFlow = viewModel.effect,
        onActionSent = { action ->  viewModel.setAction(action) },
    )
}
