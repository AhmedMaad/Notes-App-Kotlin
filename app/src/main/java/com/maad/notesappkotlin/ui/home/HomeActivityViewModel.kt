package com.maad.notesappkotlin.ui.note.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.maad.notesappkotlin.database.RoomDBHelper
import com.maad.notesappkotlin.data.Note

class HomeActivityViewModel(app: Application) : AndroidViewModel(app) {

    val allNotes: LiveData<List<Note>>
    private val db: RoomDBHelper

    init {
        db = RoomDBHelper.getDBInstance(app)
        allNotes = db.noteDao().getAllNotes()
    }

}