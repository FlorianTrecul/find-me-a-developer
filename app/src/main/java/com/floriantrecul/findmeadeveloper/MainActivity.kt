package com.floriantrecul.findmeadeveloper

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.floriantrecul.findmeadeveloper.navigation.FindMeADeveloppeAppNavigator
import com.floriantrecul.findmeadeveloper.ui.theme.FindMeADeveloperTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = Color.TRANSPARENT
            FindMeADeveloppeHome()
        }
    }
}

@Composable
fun FindMeADeveloppeHome() {
    FindMeADeveloperTheme {
        FindMeADeveloppeAppNavigator()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FindMeADeveloperTheme() {
        FindMeADeveloppeHome()
    }
}