package com.floriantrecul.findmeadeveloper.presentation.screens.home.components.repository

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun RepositoryIcon(
    icon: ImageVector,
    count: String
) {
    Icon(
        imageVector = icon,
        contentDescription = null,
        tint = MaterialTheme.colors.onSurface.copy(alpha = 0.4f)
    )
    Spacer(modifier = Modifier.size(4.dp))
    Text(
        text = count,
        style = MaterialTheme.typography.caption,
    )
    Spacer(modifier = Modifier.size(8.dp))
}