package com.example.notesapp.Ui.Fragments

import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notesapp.Adapter.NoteAdapter
import com.example.notesapp.Model.Note
import com.example.notesapp.Viewmodels.NoteViewmodel
import com.example.notesapp.databinding.NotefragmentBinding

class NoteFragment : Fragment() {

    private var _binding : NotefragmentBinding? = null
    private val binding = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = NotefragmentBinding.inflate(inflater,container,false)
        val view = binding.root
        val viewmodel : NoteViewmodel by activityViewModels()
        binding.fbNote.setOnClickListener(View.OnClickListener {
            viewmodel.addNote(Note(0,"test","data"))
        })
        binding.rvNotes.layoutManager = LinearLayoutManager(this.context)
        viewmodel.notes.observe(this, Observer {
            var listnotes = it
            var adapter = NoteAdapter(listnotes)
            binding.rvNotes.adapter = adapter
        })

        viewmodel.getAllNote()
        return view
    }

}