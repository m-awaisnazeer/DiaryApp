package com.example.diaryapp.presentation.screens.write

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.diaryapp.model.Diary

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WriteScreen(
    selectedDiary: Diary? = null,
    onDeleteConfirmed: () -> Unit,
    onBackPressed: () -> Unit

) {
    Scaffold(topBar = {
        WriteTopBar(
            selectedDiary = selectedDiary,
            onDeleteConfirmed = onDeleteConfirmed,
            onBackPressed = onBackPressed
        )
    }) {

    }
}