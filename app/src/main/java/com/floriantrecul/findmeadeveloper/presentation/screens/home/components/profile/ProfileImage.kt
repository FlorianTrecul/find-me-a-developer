package com.floriantrecul.findmeadeveloper.presentation.screens.home.components.profile

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
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
    )
}

@Composable
@Preview
fun ProfileImagePreview() {
    ProfileImage(
        image = "https://avatars.githubusercontent.com/u/17145581?v=4"
    )
}

