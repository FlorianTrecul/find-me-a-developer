package com.floriantrecul.findmeadeveloper.presentation.components

import androidx.compose.foundation.background
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource

@Composable
fun ToolbarAppBar(
    title: Int,
    color: Color
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = title),
                color = Color.White
            )
        },
        modifier = Modifier
            .background(color = color)
    )
}