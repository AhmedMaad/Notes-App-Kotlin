package com.maad.notesappkotlin.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.maad.notesappkotlin.database.Note

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

    //Suspend allows a function to run asynchronous operations within a coroutine.
    @Insert
    suspend fun insertNote(note: Note)

    //LiveData already has built-in support for asynchronous operations, so no need to add "suspend".
    @Query("SELECT * FROM note")
    fun getAllNotes(): LiveData<List<Note>>

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

}