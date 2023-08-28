package com.example.android.notesappkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import com.example.android.notesappkotlin.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this)[NoteViewModel::class.java]

        binding.addFab.setOnClickListener {
            startActivity(Intent(this, NoteActivity::class.java))
        }

        viewModel.allNotes.observe(this) {
            val detailsList = arrayListOf<String>()
            for (note in it)
                detailsList.add(note.noteDetails)
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, detailsList)
            binding.notesList.adapter = adapter
        }

    }
}