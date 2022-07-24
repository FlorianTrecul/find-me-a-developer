package com.floriantrecul.findmeadeveloper.presentation.screens.home

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.floriantrecul.findmeadeveloper.R
import com.floriantrecul.findmeadeveloper.presentation.components.SearchBar
import com.floriantrecul.findmeadeveloper.presentation.components.ToolbarAppBar

@Preview
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val searchTextState by viewModel.searchTextState

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            ToolbarAppBar(
                title = R.string.toolbar_title,
                color = MaterialTheme.colors.primaryVariant
            )
        },
        content = {
            SearchBar(
                text = searchTextState,
                onTextChange = {
                    viewModel.updateSearchTextState(newValue = it)
                },
                onSearchClicked = {
                    viewModel.onEvent(HomeEvent.GetProfile(profileUserName = it))
                }
            )
        }
    )

}