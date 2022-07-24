package com.floriantrecul.findmeadeveloper.navigation

import com.floriantrecul.findmeadeveloper.util.Constants

sealed class Screens(val route: String) {
    object HomeScreen : Screens(Constants.HOME_SCREEN)
}