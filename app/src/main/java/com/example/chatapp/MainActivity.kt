package com.example.chatapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chatapp.Screens.LoginScreen
import com.example.chatapp.Screens.SignUpScreen
import com.example.chatapp.ui.theme.ChatAppTheme

sealed class DestinationScreen(var route: String){

    object  SignUp : DestinationScreen("signup")
    object  Login : DestinationScreen("login")
    object  Profile : DestinationScreen("profile")
    object  ChatList : DestinationScreen("chatList")
    object   SingleChat: DestinationScreen("singleChat/{chatId}"){
        fun createRoute(id:String)= "singlechat/$id"
    }

    object   StatusList: DestinationScreen("StatusList")
    object   SingleStatus: DestinationScreen("singleStatus/{userId}"){
        fun createRoute(userId:String)= "singleStatus/$userId"
    }

}

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChatAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                   ChatAppNavigation()
                }
            }
        }
    }
    @Composable
    fun ChatAppNavigation(){

        var navController = rememberNavController()
        var vm = LCViewModel()
        NavHost(navController=navController, startDestination = DestinationScreen.SignUp.route){
            composable(DestinationScreen.SignUp.route){
                SignUpScreen(navController,vm)
            }
            composable(DestinationScreen.Login.route){
                LoginScreen()
            }
        }

    }
}

