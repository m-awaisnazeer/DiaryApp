package com.example.diaryapp.data.repository

import com.applications.room.database.Diary
import java.time.LocalDate

typealias Diaries = com.applications.util.model.RequestState<Map<LocalDate, List<Diary>>>

