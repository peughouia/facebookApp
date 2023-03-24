package com.example.facebooklab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.facebooklab.ui.theme.FacebookLabTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FacebookLabTheme {

                TransparentSystemBars()

                val navController = rememberNavController()
                val homeRoute = "home"
                NavHost(navController, startDestination = homeRoute){
                    val signRoute = "signin"
                    composable(homeRoute){
                        HomeScreen(
                            navigateToSignIn = {
                                navController.navigate(signRoute){
                                    popUpTo(homeRoute){
                                        inclusive = true
                                    }
                                }
                            }
                        )
                    }
                    composable("signIn"){
                        SignInScreen()
                    }
                }
            }
        }
    }
}


@Composable
 fun TransparentSystemBars() {
        val systemUiController = rememberSystemUiController()
        val useDarkIcons = MaterialTheme.colors.isLight

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = useDarkIcons
        )
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FacebookLabTheme {
        Greeting("Android")
    }
}