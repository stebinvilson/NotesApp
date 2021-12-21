package com.example.notesapp.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notesapp.Viewmodels.NoteViewmodel
import com.example.notesapp.Viewmodels.UserViewmodel
import java.lang.IllegalArgumentException

class NotesViewmodelFactory(private val context: Context) : ViewModelProvider.Factory {

   override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewmodel::class.java)) {
            return NoteViewmodel( context =context ) as T
        }
        throw IllegalArgumentException("Unknown view model class")
    }
}