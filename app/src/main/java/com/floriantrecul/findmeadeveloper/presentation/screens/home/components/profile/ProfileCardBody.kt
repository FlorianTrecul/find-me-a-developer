package com.floriantrecul.findmeadeveloper.presentation.screens.home.components.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.floriantrecul.findmeadeveloper.R
import com.floriantrecul.findmeadeveloper.domain.model.Profile
import com.floriantrecul.findmeadeveloper.util.isVisible

@Composable
fun ProfileCardBody(
    profile: Profile
) {
    Box(
        Modifier.background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(start = 16.dp, end = 16.dp)
                .offset(0.dp, (-64).dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfileImage(
                modifier = Modifier
                    .size(128.dp)
                    .clip(CircleShape)
                    .border(4.dp, Color.White, CircleShape),
                image = profile.profileImageUrl
            )
            Spacer(modifier = Modifier.height(4.dp))
            if (profile.name.isVisible()) {
                ProfileUserName(
                    userName = profile.name!!,
                    fontSize = MaterialTheme.typography.h4.fontSize,
                    fontWeight = FontWeight.Bold,
                )
            }
            ProfileUserName(
                userName = profile.login,
                fontSize = MaterialTheme.typography.h6.fontSize,
                fontWeight = FontWeight.Normal,
            )
            Spacer(modifier = Modifier.height(4.dp))
            if (profile.location.isVisible()) {
                ProfileLocation(
                    icon = R.drawable.location,
                    location = profile.location!!
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 16.dp, end = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                ProfileStat(
                    title = R.string.title_repositories,
                    numberText = profile.publicRepos
                )
                ProfileStat(
                    title = R.string.title_following,
                    numberText = profile.following
                )
                ProfileStat(
                    title = R.string.title_followers,
                    numberText = profile.followers
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            if (profile.bio.isVisible()) {
                ProfileBio(bio = profile.bio!!)
                Spacer(modifier = Modifier.height(16.dp))
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 16.dp, end = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                ProfileSocialNetworkIcon(
                    url = profile.profileUrl,
                    icon = R.drawable.github
                )
                if (profile.email.isVisible()) {
                    ProfileSocialNetworkIcon(
                        url = profile.email!!,
                        icon = R.drawable.email,
                        isEmail = true
                    )
                }
                if (profile.blog.isVisible()) {
                    ProfileSocialNetworkIcon(
                        url = profile.blog!!,
                        icon = R.drawable.web
                    )
                }
                if (profile.twitterUsername.isVisible()) {
                    ProfileSocialNetworkIcon(
                        url = "https://twitter.com/${profile.twitterUsername}",
                        icon = R.drawable.twitter
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun ProfileCardBodyPreview() {
    ProfileCardBody(
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