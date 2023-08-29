package com.maad.notesappkotlin.note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.maad.notesappkotlin.database.DBHelper
import com.maad.notesappkotlin.database.Note
import kotlinx.coroutines.launch

class NoteActivityViewModel(app: Application) : AndroidViewModel(app) {

    private val db: DBHelper

    init {
        db = DBHelper.getDBInstance(app)
    }

    fun saveNote(note: Note) {
        viewModelScope.launch { db.noteDao().insertNote(note) }
    }

}