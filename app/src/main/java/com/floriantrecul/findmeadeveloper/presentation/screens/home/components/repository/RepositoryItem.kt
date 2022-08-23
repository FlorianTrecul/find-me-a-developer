package com.floriantrecul.findmeadeveloper.presentation.screens.home.components.repository

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CallSplit
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.floriantrecul.findmeadeveloper.domain.model.Repository
import com.floriantrecul.findmeadeveloper.util.buildUrlIntent
import com.floriantrecul.findmeadeveloper.util.isVisible

@Composable
fun RepositoryItem(
    context: Context = LocalContext.current,
    repository: Repository
) {

    val repoIntent = remember { repository.repoUrl.buildUrlIntent() }

    Column(
        modifier = Modifier
            .wrapContentHeight()
            .clickable { context.startActivity(repoIntent) }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column {
                Text(
                    text = repository.name,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.size(8.dp))
                if (repository.language.isVisible()) {
                    Text(
                        text = repository.language!!,
                        style = MaterialTheme.typography.subtitle2,
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    RepositoryIcon(
                        icon = Icons.Default.Visibility,
                        repository.watchersCount.toString()
                    )
                    RepositoryIcon(
                        icon = Icons.Default.StarBorder,
                        repository.stargazersCount.toString()
                    )
                    RepositoryIcon(icon = Icons.Default.CallSplit, repository.forksCount.toString())
                }
            }
        }
        Divider()
    }
}


@Composable
@Preview
fun RepositoryItemPreview() {
    RepositoryItem(
        repository = Repository(
            id = 0,
            name = "Bonjour les gens",
            fullName = "Bonjour les gens",
            repoUrl = "",
            stargazersCount = 3,
            watchersCount = 2,
            language = "Java",
            forksCount = 1
        )
    )
}