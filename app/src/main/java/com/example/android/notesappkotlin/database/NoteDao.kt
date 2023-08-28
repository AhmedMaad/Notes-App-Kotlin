package com.example.android.notesappkotlin.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {

    /*
    * Coroutines are a Kotlin feature that converts async callbacks for long-running tasks,
    * such as database or network access, into sequential code :)
    *
    * A coroutine is a concurrency design pattern that you can use on Android
    * to simplify code that executes asynchronously.
    *
    * Help to manage long-running tasks that might otherwise block the main thread
    * and cause your app to become unresponsive.
    *
    * Enabling you to write cleaner and more concise app code.
    * */

    @Insert
    suspend fun insertNote(note: Note)

    @Query("SELECT * FROM note")
    suspend fun getAllNotes(): List<Note>

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

}