package com.floriantrecul.findmeadeveloper.presentation.screens.home.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.floriantrecul.findmeadeveloper.R

@Composable
fun ProfileLocation(
    icon: Int,
    location: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            modifier = Modifier.size(32.dp),
            contentDescription = null,
            tint = Color.Black
        )
        Text(
            text = location,
            fontSize = MaterialTheme.typography.h6.fontSize,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Start
        )
    }
}

@Composable
@Preview
fun ProfileLocationPreview() {
    ProfileLocation(
        icon = R.drawable.location,
        location = "Tours"
    )
}