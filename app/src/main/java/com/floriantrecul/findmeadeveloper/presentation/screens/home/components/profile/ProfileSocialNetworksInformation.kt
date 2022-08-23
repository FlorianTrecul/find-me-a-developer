package com.floriantrecul.findmeadeveloper.presentation.screens.home.components.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.floriantrecul.findmeadeveloper.R

@Composable
fun ProfileStat(
    modifier: Modifier = Modifier,
    title: Int,
    numberText: Int,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = title))
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = numberText.toString(),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}

@Composable
@Preview
fun ProfileStatPreview() {
    ProfileStat(
        title = R.string.toolbar_title,
        numberText = 12
    )
}