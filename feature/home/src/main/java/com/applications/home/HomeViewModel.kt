package com.applications.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applications.room.database.DiaryDao
import com.applications.util.Diaries
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
    var diaries: MutableState<Diaries> = mutableStateOf(com.applications.util.model.RequestState.Idle)

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
                    diaries.value = com.applications.util.model.RequestState.Success(
                        data = result
                    )
                }

            } catch (e: Exception) {
                flow { emit(com.applications.util.model.RequestState.Error(e)) }
            }
        }
    }
}