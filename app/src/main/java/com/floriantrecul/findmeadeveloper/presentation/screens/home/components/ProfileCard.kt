package com.floriantrecul.findmeadeveloper.presentation.screens.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.floriantrecul.findmeadeveloper.domain.model.Profile

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProfileCard(
    profile: Profile
) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .wrapContentSize(),
        shape = RoundedCornerShape(8.dp),
        onClick = {}
    ) {
        Column {
            ProfileCardHeader()
            ProfileCardBody(profile = profile)
        }
    }
}


@Composable
@Preview
fun ProfileCardPreview() {
    ProfileCard(
        Profile(
            login = "DraaxKor",
            id = 0,
            profileImageUrl = "",
            profileUrl = "",
            name = "Florian Trecul",
            company = null,
            blog = null,
            location = "France",
            email = "trecul.florian@gmail.com",
            bio = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In finibus, mauris ac tempus aliquet, ipsum metus feugiat erat, sit amet aliquet nisi turpis id velit. Ut mollis mauris nec sem suscipit aliquet. Fusce iaculis in ligula et posuere. Vivamus rhoncus arcu a condimentum dictum. Sed tempor libero orci, at ullamcorper purus fermentum vel. Sed maximus, dolor quis aliquam auctor, tortor odio rutrum nisl, eget suscipit quam lectus et leo.",
            twitterUsername = "FlorianTrecul",
            publicRepos = 12,
            followers = 1234,
            following = 123,
            createdAt = ""
        )
    )
}