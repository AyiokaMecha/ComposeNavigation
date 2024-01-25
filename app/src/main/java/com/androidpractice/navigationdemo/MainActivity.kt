package com.androidpractice.navigationdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.androidpractice.navigationdemo.screens.Home
import com.androidpractice.navigationdemo.screens.Profile
import com.androidpractice.navigationdemo.screens.Welcome
import com.androidpractice.navigationdemo.ui.theme.NavigationDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.Home.route,) {
        composable(Routes.Home.route) {
            Home(navController = navController)
        }
        composable(Routes.Welcome.route) { backStackEntry ->
            val userName = backStackEntry.arguments?.getString("userName")
            Welcome(navController = navController, userName)
        }
        composable(Routes.Profile.route) {
            Profile()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavigationDemoTheme {
        MainScreen()
    }
}