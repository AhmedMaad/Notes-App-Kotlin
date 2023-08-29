package com.example.android.notesappkotlin.edit

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.notesappkotlin.database.DBHelper
import com.example.android.notesappkotlin.database.Note
import kotlinx.coroutines.launch

class EditActivityViewModel(app: Application) : AndroidViewModel(app) {

    private val db: DBHelper

    init {
        db = DBHelper.getDBInstance(app)
    }

    fun updateNote(note: Note){
        viewModelScope.launch { db.noteDao().updateNote(note) }
    }

    fun deleteNote(note: Note){
        viewModelScope.launch { db.noteDao().deleteNote(note) }
    }

}