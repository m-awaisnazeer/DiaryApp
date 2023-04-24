package com.applications.util

import com.applications.room.database.Diary
import com.applications.util.model.RequestState
import java.time.LocalDate

object Constants {

    const val APP_ID = "diaryapp-gmqhi"
    const val CLIENT_ID = "127025171203-jkhlvbvc8of5uhgqpq8b1nvli6rcodos.apps.googleusercontent.com"

    const val WRITE_SCREEN_ARG_ID_KEY = "diaryId"

    const val DIARY_DATABASE = "diary_db"
    const val DIARY_TABLE = "diary_table"
}

typealias Diaries = RequestState<Map<LocalDate, List<Diary>>>