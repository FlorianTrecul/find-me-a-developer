package com.floriantrecul.findmeadeveloper.presentation.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProfileCardHeader() {
    val color = (Math.random() * 16777215).toInt() or (0xFF shl 24)
    Box(
        Modifier
            .background(Color(color))
            .fillMaxWidth()
            .height(150.dp)
    )
}

@Composable
@Preview
fun ProfileCardHeaderPreview() {
    ProfileCardHeader()
}