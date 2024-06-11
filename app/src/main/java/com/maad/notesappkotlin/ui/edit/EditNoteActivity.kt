package com.maad.notesappkotlin.ui.note.edit

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.maad.notesappkotlin.Constants.NOTE
import com.maad.notesappkotlin.data.Note
import com.maad.notesappkotlin.R
import com.maad.notesappkotlin.databinding.ActivityEditBinding

class EditNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this)[EditNoteActivityViewModel::class.java]

        val note = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            intent.getParcelableExtra(NOTE, Note::class.java)!!
        else
            intent.getParcelableExtra(NOTE)!!

        binding.detailsEt.setText(note.noteDetails)

        binding.deleteBtn.setOnClickListener {
            viewModel.deleteNote(note)
            Toast.makeText(this, R.string.deleted, Toast.LENGTH_SHORT).show()
        }

        binding.updateBtn.setOnClickListener {
            val updatedDetails = binding.detailsEt.text.toString()
            val updatedNote = Note(note.id, updatedDetails)
            viewModel.updateNote(updatedNote)
            Toast.makeText(this, R.string.updated, Toast.LENGTH_SHORT).show()
        }

    }
}