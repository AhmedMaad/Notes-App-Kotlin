package com.maad.notesappkotlin.ui.note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.maad.notesappkotlin.database.RoomDBHelper
import com.maad.notesappkotlin.data.Note
import kotlinx.coroutines.launch

class NoteActivityViewModel(app: Application) : AndroidViewModel(app) {

    private val db: RoomDBHelper

    init {
        db = RoomDBHelper.getDBInstance(app)
    }

    fun saveNote(note: Note) {
        viewModelScope.launch { db.noteDao().insertNote(note) }
    }

}