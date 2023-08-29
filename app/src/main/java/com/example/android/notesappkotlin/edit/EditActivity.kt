package com.example.android.notesappkotlin.edit

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.android.notesappkotlin.R
import com.example.android.notesappkotlin.database.Note
import com.example.android.notesappkotlin.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this)[EditActivityViewModel::class.java]

        val note = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            intent.getParcelableExtra("note", Note::class.java)!!
        else
            intent.getParcelableExtra("note")!!

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