package com.example.diaryapp.data.repository

import com.example.diaryapp.data.repository.database.entity.Diary
import java.time.LocalDate

typealias Diaries = com.applications.util.model.RequestState<Map<LocalDate, List<Diary>>>

