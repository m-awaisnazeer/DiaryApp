package com.applications.room.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
const val DIARY_TABLE = "diary_table"

@Entity(tableName = DIARY_TABLE)
data class Diary(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var mood: String = "Neutral",
    var title: String = "",
    var description: String = "",
    var date: Date
)