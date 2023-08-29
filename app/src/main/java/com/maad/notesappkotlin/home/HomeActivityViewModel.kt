package com.maad.notesappkotlin.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.maad.notesappkotlin.database.DBHelper
import com.maad.notesappkotlin.database.Note

class HomeActivityViewModel(app: Application) : AndroidViewModel(app) {

    val allNotes: LiveData<List<Note>>
    private val db: DBHelper

    init {
        db = DBHelper.getDBInstance(app)
        allNotes = db.noteDao().getAllNotes()
    }

}