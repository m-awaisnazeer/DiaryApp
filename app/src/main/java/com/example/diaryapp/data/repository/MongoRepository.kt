package com.example.diaryapp.data.repository

import com.applications.util.model.Diary
import java.time.LocalDate

typealias Diaries = com.applications.util.model.RequestState<Map<LocalDate, List<Diary>>>

