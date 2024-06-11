package com.maad.notesappkotlin.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.maad.notesappkotlin.data.Note

@Database(entities = [Note::class], version = 1)
abstract class RoomDBHelper : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {
        //Ensures that the value of the variable is always up-to-date,
        //and any changes to the variable should be immediately visible to all threads.
        @Volatile
        private var INSTANCE: RoomDBHelper? = null

        fun getDBInstance(context: Context): RoomDBHelper {
            //Lock the current object to prevent race conditions.
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(context, RoomDBHelper::class.java, "MyDB").build()
                INSTANCE = instance

                instance
            }
        }

    }

}