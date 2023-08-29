package com.example.android.notesappkotlin.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import com.example.android.notesappkotlin.note.NoteActivity
import com.example.android.notesappkotlin.database.Note
import com.example.android.notesappkotlin.databinding.ActivityHomeBinding
import com.example.android.notesappkotlin.edit.EditActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this)[HomeActivityViewModel::class.java]

        binding.addFab.setOnClickListener {
            startActivity(Intent(this, NoteActivity::class.java))
        }

        var notes = arrayListOf<Note>()

        viewModel.allNotes.observe(this) {
            notes = it as ArrayList<Note>
            val detailsList = arrayListOf<String>()
            for (note in it)
                detailsList.add(note.noteDetails)
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, detailsList)
            binding.notesList.adapter = adapter
        }

        binding.notesList.setOnItemClickListener { parent, view, position, id ->
            val i = Intent(this, EditActivity::class.java)
            i.putExtra("note", notes[position])
            startActivity(i)
        }

    }

}