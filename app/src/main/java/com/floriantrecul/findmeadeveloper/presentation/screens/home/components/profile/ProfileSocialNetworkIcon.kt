package com.floriantrecul.findmeadeveloper.presentation.screens.home.components.profile

import android.content.Context
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.floriantrecul.findmeadeveloper.R
import com.floriantrecul.findmeadeveloper.util.buildEmailIntent
import com.floriantrecul.findmeadeveloper.util.buildUrlIntent

@Composable
fun ProfileSocialNetworkIcon(
    context: Context = LocalContext.current,
    url: String,
    icon: Int,
    isEmail: Boolean = false
) {
    IconButton(
        onClick = {
            when (isEmail) {
                true -> context.startActivity(url.buildEmailIntent())
                false -> context.startActivity(url.buildUrlIntent())
            }
        },
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = Color.Black
        )
    }
}

@Composable
@Preview
fun ProfileSocialNetworkPreview() {
    ProfileSocialNetworkIcon(
        url = "https://github.com/FlorianTrecul",
        icon = R.drawable.email
    )
}