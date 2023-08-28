package com.example.android.notesappkotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.notesappkotlin.database.DBHelper
import com.example.android.notesappkotlin.database.Note
import kotlinx.coroutines.launch

class NoteViewModel(app: Application) : AndroidViewModel(app) {

    val db: DBHelper

    init {
        db = DBHelper.getDBInstance(app)
    }

    fun saveNote(note: Note) {
        viewModelScope.launch { db.noteDao().insertNote(note) }
    }

}