package com.example.diaryapp.presentation.screens.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diaryapp.data.repository.Diaries
import com.example.diaryapp.data.repository.database.DiaryDao
import com.example.diaryapp.model.RequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import java.time.ZoneId
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val diaryDao: DiaryDao
) : ViewModel() {
    var diaries: MutableState<Diaries> = mutableStateOf(RequestState.Idle)

    init {
        observeAllDiaries()
    }

    private fun observeAllDiaries() {
        viewModelScope.launch {
            try {
                diaryDao.getAllImages().collectLatest { list ->
                    val result = list.groupBy {
                        it.date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
                    }
                    diaries.value = RequestState.Success(
                        data = result
                    )
                }

            } catch (e: Exception) {
                flow { emit(RequestState.Error(e)) }
            }
        }
    }
}