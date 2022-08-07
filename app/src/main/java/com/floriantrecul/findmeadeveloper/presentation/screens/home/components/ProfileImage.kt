package com.floriantrecul.findmeadeveloper.presentation.screens.home.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.floriantrecul.findmeadeveloper.R

@Composable
fun ProfileImage(
    modifier: Modifier = Modifier,
    image: String
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(image)
            .crossfade(true)
            .build(),
        contentDescription = stringResource(R.string.app_name),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(128.dp)
            .clip(CircleShape)
            .border(4.dp, Color.White, CircleShape)
    )
}

@Composable
@Preview
fun ProfileImagePreview() {
    ProfileImage(
        modifier = Modifier,
        image = "https://avatars.githubusercontent.com/u/17145581?v=4"
    )
}

