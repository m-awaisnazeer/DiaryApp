package com.applications.util

import com.applications.util.Constants.WRITE_SCREEN_ARG_ID_KEY


sealed class Screen(val route: String) {
    object Authentication : Screen("authentication_screen")
    object Home : Screen("home_screen")
    object Write : Screen("write_screen?$WRITE_SCREEN_ARG_ID_KEY={$WRITE_SCREEN_ARG_ID_KEY}") {
        fun passDiaryId(diaryId: String) = "write_screen?$WRITE_SCREEN_ARG_ID_KEY=$diaryId"
    }
}
