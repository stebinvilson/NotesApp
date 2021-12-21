package com.example.notesapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.Model.Note
import com.example.notesapp.R
import com.example.notesapp.databinding.ListItemNoteBinding

class NoteAdapter(private val mList: List<Note>) :
    RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = ListItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            binding.txtNote.text = mList.get(position).note
        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(val binding: ListItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}
