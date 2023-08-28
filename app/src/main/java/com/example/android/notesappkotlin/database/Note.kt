package com.example.android.notesappkotlin.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("note")
class Note(
    @PrimaryKey(true)
    val id: Int = 0,
    @ColumnInfo("note_details")
    val noteDetails: String
)