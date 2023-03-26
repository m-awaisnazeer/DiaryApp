package com.example.diaryapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.diaryapp.presentation.screens.AuthenticationScreen
import com.example.diaryapp.utils.Constants.WRITE_SCREEN_ARG_ID_KEY

@Composable
fun SetUpNavGraph(
    startDestination: String, navHostController: NavHostController
) {
    NavHost(
        navController = navHostController, startDestination = startDestination
    ) {
        authenticateRoute()
        homeRoute()
        writeRoute()
    }
}

fun NavGraphBuilder.authenticateRoute() {
    composable(route = Screen.Authentication.route) {
        AuthenticationScreen()
    }
}

fun NavGraphBuilder.homeRoute() {
    composable(route = Screen.Home.route) {

    }
}

fun NavGraphBuilder.writeRoute() {
    composable(
        route = Screen.Write.route,
        arguments = listOf(navArgument(name = WRITE_SCREEN_ARG_ID_KEY) {
            type = NavType.StringType
            nullable = true
            defaultValue = null
        })
    ) {

    }
}