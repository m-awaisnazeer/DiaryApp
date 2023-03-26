@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.diaryapp.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AuthenticationScreen() {
    Scaffold(
        content = { AuthenticationContent() }
    )
}