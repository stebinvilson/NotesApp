package com.example.notesapp.Viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.Model.Note
import com.example.notesapp.Model.UserEntity
import com.example.notesapp.Repository.NoteRepository
import com.example.notesapp.room.NoteDatabase
import kotlinx.coroutines.launch

class NoteViewmodel(context: Context) : ViewModel() {

    private val repository : NoteRepository

    var notes : MutableLiveData<List<Note>> = MutableLiveData()

    init {
        val dao = NoteDatabase.getInstance(context).notedao()
        repository = NoteRepository(dao)
    }


    fun addNote(note : Note){
        viewModelScope.launch {
            repository.addnote(note)

        }
    }


    fun editnote(note: Note) {
        viewModelScope.launch {
            repository.updatenote(note)

        }
    }

    fun getAllNote(){
        viewModelScope.launch {
         notes.value =   repository.getAllNotes()

        }
    }

}