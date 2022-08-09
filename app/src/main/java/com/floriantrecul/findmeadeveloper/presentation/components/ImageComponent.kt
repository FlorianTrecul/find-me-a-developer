package com.floriantrecul.findmeadeveloper.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.floriantrecul.findmeadeveloper.R

@Composable
fun ImageComponent(
    modifier: Modifier = Modifier,
    image: Int
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(image)
            .crossfade(true)
            .build(),
        contentDescription = stringResource(R.string.app_name),
        modifier = modifier
    )
}

@Composable
@Preview
fun ImageComponentPreview() {
    ImageComponent(
        image = R.drawable.inspectocat
    )
}

