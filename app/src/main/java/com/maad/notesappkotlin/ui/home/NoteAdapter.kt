package com.maad.notesappkotlin.ui.note.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.maad.notesappkotlin.data.Note
import com.maad.notesappkotlin.databinding.NoteListItemBinding

class NoteAdapter(
    private val notes: ArrayList<Note>,
    private val onItemClickListener: OnItemClickListener
) : Adapter<NoteAdapter.NoteViewHolder>() {

    fun interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    class NoteViewHolder(val binding: NoteListItemBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        //Reference: https://stackoverflow.com/questions/68693109/using-viewbinding-in-recyclerview-adapter-wierldly-displays-items
        val binding =
            NoteListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        val holder = NoteViewHolder(binding)
        holder.binding.noteContainerCv.setOnClickListener {
            onItemClickListener.onItemClick(holder.adapterPosition)
        }

        return holder
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.binding.noteDetailsTv.text = notes[position].noteDetails
    }

}