package com.maad.notesappkotlin.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity("note")
class Note(
    @PrimaryKey(true)
    val id: Int = 0,
    @ColumnInfo("note_details")
    val noteDetails: String
) : Parcelable