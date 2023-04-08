package com.example.diaryapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.diaryapp.presentation.screens.auth.AuthenticationScreen
import com.example.diaryapp.presentation.screens.auth.AuthenticationViewModel
import com.example.diaryapp.utils.Constants.WRITE_SCREEN_ARG_ID_KEY
import com.stevdzasan.messagebar.rememberMessageBarState
import com.stevdzasan.onetap.rememberOneTapSignInState

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
        val viewModel: AuthenticationViewModel = viewModel()

        val loadingState by viewModel.loadingState
        val oneTapState = rememberOneTapSignInState()
        val messageBarState = rememberMessageBarState()

        AuthenticationScreen(loadingState = loadingState,
            oneTapSignInState = oneTapState,
            messageBarState = messageBarState,
            onButtonClicked = {
                oneTapState.open()
                viewModel.setLoading(true)
            },
            onTokenIdReceived = {
                viewModel.signInWithMongoAtlas(tokenId = it, onSuccess = {
                    if (it) {
                        messageBarState.addSuccess("Successfully Authenticated")
                        viewModel.setLoading(false)
                    }
                }, onError = {
                    messageBarState.addError(it)
                    viewModel.setLoading(false)
                })
            },
            onDialogDismissed = {
                messageBarState.addError(Exception(it))
            })
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