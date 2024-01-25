package com.androidpractice.navigationdemo

sealed class Routes(val route: String) {
    object Home : Routes("home")
    object Welcome : Routes("welcome")
    object Profile : Routes("profile")
}
