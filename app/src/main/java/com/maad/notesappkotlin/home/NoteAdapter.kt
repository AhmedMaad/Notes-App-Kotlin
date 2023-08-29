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
import com.maad.notesappkotlin.edit.EditNoteActivity

class NoteAdapter(private val activity: Activity, private val notes: ArrayList<Note>) :
    Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(view: View): ViewHolder(view) {
        val noteContainer: CardView = view.findViewById(R.id.note_container_cv)
        val noteDetails: TextView = view.findViewById(R.id.note_details_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = activity.layoutInflater.inflate(R.layout.note_list_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.noteDetails.text = notes[position].noteDetails

        holder.noteContainer.setOnClickListener {
            val  i = Intent(activity, EditNoteActivity::class.java)
            i.putExtra("note", notes[position])
            activity.startActivity(i)
        }

    }


}