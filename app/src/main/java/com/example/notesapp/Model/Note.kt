package com.example.notesapp.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Note_table")
data class Note(@PrimaryKey(autoGenerate = false) val id: Int? = null,@ColumnInfo(name = "notename")var notename : String,@ColumnInfo(name = "note")var note : String)
