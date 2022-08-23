package com.floriantrecul.findmeadeveloper.presentation.screens.home.components.profile

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ProfileBio(
    bio: String
) {
    Text(
        text = bio,
        fontSize = MaterialTheme.typography.h6.fontSize,
        fontWeight = FontWeight.Normal,
        overflow = TextOverflow.Ellipsis,
        maxLines = 3
    )
}

@Composable
@Preview
fun ProfileBioPreview() {
    ProfileBio(
        bio = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In finibus, mauris ac tempus aliquet, ipsum metus feugiat erat, sit amet aliquet nisi turpis id velit. Ut mollis mauris nec sem suscipit aliquet. Fusce iaculis in ligula et posuere. Vivamus rhoncus arcu a condimentum dictum. Sed tempor libero orci, at ullamcorper purus fermentum vel. Sed maximus, dolor quis aliquam auctor, tortor odio rutrum nisl, eget suscipit quam lectus et leo."
    )
}