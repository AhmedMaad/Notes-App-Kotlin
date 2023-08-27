package com.example.android.notesappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.notesappkotlin.databinding.ActivityNoteBinding

class NoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveBtn.setOnClickListener {
            val details = binding.detailsEt.text.toString()
        }

    }
}