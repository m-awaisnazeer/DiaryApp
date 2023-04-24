package com.example.diaryapp.data.repository.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.diaryapp.model.Mood
import com.example.diaryapp.utils.Constants.DIARY_TABLE
import java.util.Date

@Entity(tableName = DIARY_TABLE)
data class Diary(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var mood: String = Mood.Neutral.name,
    var title: String = "",
    var description: String = "",
    var date: Date
)