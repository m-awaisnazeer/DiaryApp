package com.example.diaryapp.presentation.screens.write

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applications.util.Constants.WRITE_SCREEN_ARG_ID_KEY
import com.applications.util.model.Diary
import com.example.diaryapp.data.repository.database.DiaryDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.ZonedDateTime
import javax.inject.Inject

@HiltViewModel
class WriteViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val diaryDao: DiaryDao
) : ViewModel() {
    var uiState by mutableStateOf(UiState())
        private set

    init {
        getDiaryIdArgument()
        fetchSelectedDiary()
    }

    private fun getDiaryIdArgument() {
        uiState = uiState.copy(
            selectedDiaryId = savedStateHandle.get<String>(
                key = WRITE_SCREEN_ARG_ID_KEY
            )?.toInt()
        )
    }

    private fun fetchSelectedDiary() {
        if (uiState.selectedDiaryId != null) {
            viewModelScope.launch {
                val diary = diaryDao.getDiaryById(uiState.selectedDiaryId!!)
                setMood(mood = com.applications.util.model.Mood.valueOf(diary.mood))
                setSelectedDiary(diary = diary)
                setTitle(title = diary.title)
                setDescription(description = diary.description)
            }
        }
    }

    private fun setSelectedDiary(diary: Diary) {
        uiState = uiState.copy(selectedDiary = diary)
    }

    fun setTitle(title: String) {
        uiState = uiState.copy(title = title)
    }

    fun setDescription(description: String) {
        uiState = uiState.copy(description = description)
    }

    private fun setMood(mood: com.applications.util.model.Mood) {
        uiState = uiState.copy(mood = mood)
    }


    fun upsertDiary(
        diary: Diary, onSuccess: () -> Unit, onError: (String) -> Unit
    ) {
        Log.d("mTAG", "upsertDiary: ")
        viewModelScope.launch(Dispatchers.IO) {
            if (uiState.selectedDiaryId != null) {
                updateDiary(diary = diary, onSuccess = onSuccess, onError = onError)
            } else {
                insertDiary(diary = diary, onSuccess = onSuccess, onError = onError)
            }
        }
    }

    private suspend fun insertDiary(
        diary: Diary,
        onSuccess: () -> Unit,
        onError: (String) -> Unit,
    ) {
        Log.d("mTAG", "insertDiary: ")
        diaryDao.addDiary(diary)
        withContext(Dispatchers.Main) {
            onSuccess()
        }
    }

    private suspend fun updateDiary(
        diary: Diary, onSuccess: () -> Unit, onError: (String) -> Unit
    ) {
        diaryDao.updateDiary(diary)
        withContext(Dispatchers.Main) {
            onSuccess()
        }
    }

    fun deleteDiary(
        onSuccess: () -> Unit, onError: (String) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            if (uiState.selectedDiaryId != null) {

            }
        }
    }

    fun updateDateTime(zonedDateTime: ZonedDateTime) {
    }
}


data class UiState(
    val selectedDiaryId: Int? = null,
    val selectedDiary: Diary? = null,
    val title: String = "",
    val description: String = "",
    val mood: com.applications.util.model.Mood = com.applications.util.model.Mood.Neutral
)