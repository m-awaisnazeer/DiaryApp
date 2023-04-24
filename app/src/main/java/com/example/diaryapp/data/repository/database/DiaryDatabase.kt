package com.example.diaryapp.data.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.applications.util.model.Diary

@Database(
    entities = [Diary::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class DiaryDatabase : RoomDatabase() {
    abstract fun diaryDao(): DiaryDao
}