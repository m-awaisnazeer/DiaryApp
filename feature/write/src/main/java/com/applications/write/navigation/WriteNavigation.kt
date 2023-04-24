@file:OptIn(ExperimentalPagerApi::class)

package com.applications.write.navigation

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.applications.util.Constants
import com.applications.util.Screen
import com.applications.util.model.Mood
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

fun NavGraphBuilder.writeRoute(
    navigateBack: () -> Unit
) {
    composable(
        route = Screen.Write.route, arguments = listOf(navArgument(name = Constants.WRITE_SCREEN_ARG_ID_KEY) {
            type = NavType.StringType
            nullable = true
            defaultValue = null
        })
    ) {
        val viewModel: com.applications.write.WriteViewModel = hiltViewModel()
        val context = LocalContext.current
        val uiState = viewModel.uiState
        val pagerState = rememberPagerState()
        val pageNumber by remember { derivedStateOf { pagerState.currentPage } }

        com.applications.write.WriteScreen(
            uiState = uiState,
            pagerState = pagerState,
            moodName = { Mood.values()[pageNumber].name },
            onTitleChanged = { viewModel.setTitle(title = it) },
            onDescriptionChanged = { viewModel.setDescription(description = it) },
            onDateTimeUpdated = { viewModel.updateDateTime(zonedDateTime = it) },
            onBackPressed = navigateBack,
            onDeleteConfirmed = {
                viewModel.deleteDiary(onSuccess = {
                    Toast.makeText(
                        context, "Deleted", Toast.LENGTH_SHORT
                    ).show()
                    navigateBack()
                }, onError = { message ->
                    Toast.makeText(
                        context, message, Toast.LENGTH_SHORT
                    ).show()
                })
            },
            onSaveClicked = {
                Log.d("mTAG", "onSavedClickec: ")
                viewModel.upsertDiary(diary = it.apply {
                    mood = Mood.values()[pageNumber].name
                }, onSuccess = navigateBack, onError = { message ->
                    Toast.makeText(
                        context, message, Toast.LENGTH_SHORT
                    ).show()
                })
            })
    }
}