package com.example.android.notesappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.notesappkotlin.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.deleteBtn.setOnClickListener { }

        binding.updateBtn.setOnClickListener {
            val updatedDetails = binding.detailsEt.text.toString()
        }

    }
}