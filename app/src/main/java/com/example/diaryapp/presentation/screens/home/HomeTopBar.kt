package com.example.diaryapp.presentation.screens.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(onMenuClicked: () -> Unit) {
    TopAppBar(navigationIcon = {
        IconButton(onClick = onMenuClicked) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Hamburger Menu Icon",
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
    }, title = {
        Text(text = "Diary")
    }, actions = {
        IconButton(onClick = onMenuClicked) {
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = "Date Icon",
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
    })
}