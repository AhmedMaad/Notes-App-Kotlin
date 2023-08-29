package com.maad.notesappkotlin.home

import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.maad.notesappkotlin.R
import com.maad.notesappkotlin.database.Note
import com.maad.notesappkotlin.databinding.NoteListItemBinding
import com.maad.notesappkotlin.edit.EditNoteActivity

class NoteAdapter(private val activity: Activity, private val notes: ArrayList<Note>) :
    Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(val binding: NoteListItemBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        //Reference: https://stackoverflow.com/questions/68693109/using-viewbinding-in-recyclerview-adapter-wierldly-displays-items
        val binding = NoteListItemBinding.inflate(activity.layoutInflater, parent, false)
        return NoteViewHolder(binding)
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.binding.noteDetailsTv.text = notes[position].noteDetails
        holder.binding.noteContainerCv.setOnClickListener {
            val i = Intent(activity, EditNoteActivity::class.java)
            i.putExtra("note", notes[position])
            activity.startActivity(i)
        }

    }


}