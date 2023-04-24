package com.example.diaryapp.data.repository.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.applications.util.Constants.DIARY_TABLE
import java.util.Date

@Entity(tableName = DIARY_TABLE)
data class Diary(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var mood: String = com.applications.util.model.Mood.Neutral.name,
    var title: String = "",
    var description: String = "",
    var date: Date
)