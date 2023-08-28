package com.example.android.notesappkotlin

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.notesappkotlin.database.Note
import com.example.android.notesappkotlin.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val note = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            intent.getParcelableExtra("note", Note::class.java)
        else
            intent.getParcelableExtra<Note>("note")

        binding.detailsEt.setText(note?.noteDetails)

        binding.deleteBtn.setOnClickListener { }

        binding.updateBtn.setOnClickListener {
            val updatedDetails = binding.detailsEt.text.toString()
        }

    }
}