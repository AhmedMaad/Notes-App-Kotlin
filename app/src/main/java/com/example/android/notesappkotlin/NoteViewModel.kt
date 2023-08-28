package com.example.android.notesappkotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.android.notesappkotlin.database.DBHelper
import com.example.android.notesappkotlin.database.Note
import kotlinx.coroutines.launch

class NoteViewModel(app: Application) : AndroidViewModel(app) {

    private val db: DBHelper
    val allNotes: LiveData<List<Note>>

    init {
        db = DBHelper.getDBInstance(app)
        allNotes = db.noteDao().getAllNotes()
    }

    fun saveNote(note: Note) {
        viewModelScope.launch { db.noteDao().insertNote(note) }
    }

}