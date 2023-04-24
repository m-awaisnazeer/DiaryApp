package com.example.diaryapp.data.repository.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.diaryapp.data.repository.database.entity.Diary
import kotlinx.coroutines.flow.Flow

@Dao
interface DiaryDao {

    @Query("SELECT * FROM diary_table ORDER BY id ASC")
    fun getAllImages(): Flow<List<Diary>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addDiary(diary: Diary)

    @Update
    suspend fun updateDiary(diary: Diary)
    @Query("DELETE FROM diary_table WHERE id=:diaryId")
    suspend fun deleteDiary(diaryId: Int)

    @Query("SELECT * FROM diary_table WHERE id=:diaryId")
    suspend fun getDiaryById(diaryId: Int): Diary
}