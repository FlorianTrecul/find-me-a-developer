package com.floriantrecul.findmeadeveloper.presentation.screens.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.floriantrecul.findmeadeveloper.R

@Composable
fun ProfileEmpty() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = stringResource(id = R.string.toolbar_title))
    }

}

@Composable
@Preview
fun ProfileEmptyPreview() {
    ProfileEmpty()
}