package com.floriantrecul.findmeadeveloper.presentation.screens.home.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.floriantrecul.findmeadeveloper.domain.model.Profile


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RepositoryCard(
    modifier: Modifier = Modifier,
    profile: Profile,
    color: Int
) {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(targetValue = if (expandedState) 180f else 0f)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .offset(0.dp, (-32).dp)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            )
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color(color),
        onClick = {
            expandedState = !expandedState
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.weight(6f),
                    text = "Repositories (${profile.publicRepos})",
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = FontWeight.Bold,
                )
                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                        .weight(1f)
                        .rotate(rotationState),
                    onClick = {
                        expandedState = !expandedState
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "ArrowDropDown Icon",
                    )
                }
            }
            if (expandedState) {
                Text(text = "jdjdjdjdjdjdj")
            }
        }
    }
}


@Composable
@Preview
fun RepositoryCardPreview() {
    RepositoryCard(
        profile =
        Profile(
            login = "DraaxKor",
            id = 0,
            profileImageUrl = "",
            profileUrl = "",
            name = "Florian Trecul",
            company = null,
            blog = null,
            location = "France",
            email = "trecul.florian@gmail.com",
            bio = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In finibus, mauris ac tempus aliquet, ipsum metus feugiat erat, sit amet aliquet nisi turpis id velit. Ut mollis mauris nec sem suscipit aliquet. Fusce iaculis in ligula et posuere. Vivamus rhoncus arcu a condimentum dictum. Sed tempor libero orci, at ullamcorper purus fermentum vel. Sed maximus, dolor quis aliquam auctor, tortor odio rutrum nisl, eget suscipit quam lectus et leo.",
            twitterUsername = "FlorianTrecul",
            publicRepos = 12,
            followers = 1234,
            following = 123,
            createdAt = ""
        ),
        color = 3
    )
}
