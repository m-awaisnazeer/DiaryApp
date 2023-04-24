package com.applications.util.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.applications.util.Constants.DIARY_TABLE
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