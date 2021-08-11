package com.health.roomdb.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.health.roomdb.R
import com.health.roomdb.model.Note

class NotesAdapter : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {
    var mainNoteList: List<Note> = emptyList()

    fun setData(noteList: List<Note>) {
        mainNoteList = noteList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(mainNoteList[position])
    }

    override fun getItemCount(): Int {
        return mainNoteList.size
    }

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: MaterialTextView = itemView.findViewById(R.id.tv_title)
        private val message: MaterialTextView = itemView.findViewById(R.id.tv_message)

        fun bind(note: Note) {
            Log.d("@@Data","${note.title}")
            title.text = note.title
            message.text = note.message
        }
    }
}