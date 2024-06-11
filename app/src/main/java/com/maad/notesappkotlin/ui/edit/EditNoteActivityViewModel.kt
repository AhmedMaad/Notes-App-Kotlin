package com.maad.notesappkotlin.ui.note.edit

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.maad.notesappkotlin.database.RoomDBHelper
import com.maad.notesappkotlin.data.Note
import kotlinx.coroutines.launch

class EditNoteActivityViewModel(app: Application) : AndroidViewModel(app) {

    private val db: RoomDBHelper

    init {
        db = RoomDBHelper.getDBInstance(app)
    }

    fun updateNote(note: Note){
        viewModelScope.launch { db.noteDao().updateNote(note) }
    }

    fun deleteNote(note: Note){
        viewModelScope.launch { db.noteDao().deleteNote(note) }
    }

}