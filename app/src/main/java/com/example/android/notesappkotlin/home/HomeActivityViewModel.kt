package com.example.android.notesappkotlin.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.android.notesappkotlin.database.DBHelper
import com.example.android.notesappkotlin.database.Note

class HomeActivityViewModel(app: Application) : AndroidViewModel(app) {

    val allNotes: LiveData<List<Note>>
    private val db: DBHelper

    init {
        db = DBHelper.getDBInstance(app)
        allNotes = db.noteDao().getAllNotes()
    }

}