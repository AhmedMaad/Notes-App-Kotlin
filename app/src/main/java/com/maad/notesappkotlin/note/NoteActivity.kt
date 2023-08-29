package com.maad.notesappkotlin.note

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.maad.notesappkotlin.database.Note
import com.maad.notesappkotlin.R
import com.maad.notesappkotlin.databinding.ActivityNoteBinding

class NoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this)[NoteActivityViewModel::class.java]

        binding.saveBtn.setOnClickListener {
            val details = binding.detailsEt.text.toString()
            val note = Note(noteDetails = details)
            viewModel.saveNote(note)
            Toast.makeText(this, R.string.saved, Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}