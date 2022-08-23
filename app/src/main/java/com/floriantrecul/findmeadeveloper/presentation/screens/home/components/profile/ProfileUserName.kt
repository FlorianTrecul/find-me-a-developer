package com.floriantrecul.findmeadeveloper.presentation.screens.home.components.profile

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit

@Composable
fun ProfileUserName(
    userName: String,
    fontSize: TextUnit,
    fontWeight: FontWeight
) {
    Text(
        text = userName,
        fontSize = fontSize,
        fontWeight = fontWeight,
    )
}

@Composable
@Preview
fun ProfileUserNamePreview() {
    ProfileUserName(
        userName = "Florian Trecul",
        fontSize = MaterialTheme.typography.h4.fontSize,
        fontWeight = FontWeight.Bold
    )
}