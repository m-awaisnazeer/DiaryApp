package com.example.diaryapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.applications.auth.navigation.authenticateRoute
import com.applications.home.navigation.homeRoute
import com.applications.util.Screen
import com.applications.write.navigation.writeRoute
import com.google.accompanist.pager.ExperimentalPagerApi

@Composable
fun SetUpNavGraph(
    startDestination: String, navHostController: NavHostController, onDataLoaded: () -> Unit
) {
    NavHost(
        navController = navHostController, startDestination = startDestination
    ) {
        authenticateRoute(
            navigateToHome = {
                navHostController.popBackStack()
                navHostController.navigate(Screen.Home.route)
            }, onDataLoaded = onDataLoaded
        )
        homeRoute(navigateToWrite = { navHostController.navigate(Screen.Write.route) },
            navigateToAuth = {
                navHostController.popBackStack()
                navHostController.navigate(Screen.Authentication.route)
            },navigateToWriteWithArgs = {
                navHostController.navigate(Screen.Write.passDiaryId(diaryId = it))
            },
            onDataLoaded = onDataLoaded
        )
        writeRoute(navigateBack = {
            navHostController.popBackStack()
        })
    }
}
