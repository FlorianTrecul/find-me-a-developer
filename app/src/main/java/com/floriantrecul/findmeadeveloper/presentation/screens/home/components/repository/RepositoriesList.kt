package com.floriantrecul.findmeadeveloper.presentation.screens.home.components.repository

import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.floriantrecul.findmeadeveloper.domain.model.Repository

@Composable
fun RepositoriesList(
    repositories: List<Repository>
) {
    LazyColumn(
        modifier = Modifier.wrapContentHeight()
    ) {
        items(repositories) { repository ->
            RepositoryItem(repository = repository)
        }
    }
}

@Composable
@Preview
fun RepositoriesListPreview() {
    RepositoriesList(
        repositories = emptyList()
    )
}