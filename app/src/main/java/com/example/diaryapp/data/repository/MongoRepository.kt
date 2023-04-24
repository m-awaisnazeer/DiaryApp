package com.example.diaryapp.data.repository

import com.example.diaryapp.data.repository.database.entity.Diary
import com.example.diaryapp.model.RequestState
import java.time.LocalDate

typealias Diaries = RequestState<Map<LocalDate, List<Diary>>>

