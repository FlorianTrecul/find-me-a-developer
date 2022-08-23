package com.floriantrecul.findmeadeveloper.presentation.screens.home.components.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.floriantrecul.findmeadeveloper.R
import com.floriantrecul.findmeadeveloper.presentation.components.ImageComponent

@Composable
fun ProfileEmpty(
    image: Int,
    text: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ImageComponent(image = image)
        Text(
            text = stringResource(id = text),
            fontSize = MaterialTheme.typography.h5.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview
fun ProfileEmptyPreview() {
    ProfileEmpty(
        image = R.drawable.inspectocat,
        text = R.string.message_search
    )
}