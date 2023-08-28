package com.example.android.notesappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.android.notesappkotlin.database.Note
import com.example.android.notesappkotlin.databinding.ActivityNoteBinding

class NoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        binding.saveBtn.setOnClickListener {
            val details = binding.detailsEt.text.toString()
            val note = Note(noteDetails = details)
            viewModel.saveNote(note)
        }

    }
}