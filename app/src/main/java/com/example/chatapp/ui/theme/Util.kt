package com.example.chatapp.ui.theme

import androidx.navigation.NavController

fun navigateTo(navController: NavController,route:String){


    navController.navigate(route){
        popUpTo(route)
        launchSingleTop=true
    }
}