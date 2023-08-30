package com.maad.notesappkotlin.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import com.maad.notesappkotlin.note.NoteActivity
import com.maad.notesappkotlin.database.Note
import com.maad.notesappkotlin.databinding.ActivityHomeBinding
import com.maad.notesappkotlin.edit.EditNoteActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this)[HomeActivityViewModel::class.java]

        binding.addFab.setOnClickListener {
            startActivity(Intent(this, NoteActivity::class.java))
        }

        viewModel.allNotes.observe(this) {
            val notes = it as ArrayList<Note>
            val adapter = NoteAdapter(notes) { position ->
                val i = Intent(this, EditNoteActivity::class.java)
                i.putExtra("note", notes[position])
                startActivity(i)
            }
            binding.notesList.adapter = adapter
        }

    }

}