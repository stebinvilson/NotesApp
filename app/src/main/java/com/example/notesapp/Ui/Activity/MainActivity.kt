package com.example.notesapp.Ui.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import com.example.notesapp.R
import com.example.notesapp.Viewmodels.NoteViewmodel
import com.example.notesapp.Viewmodels.UserViewmodel
import com.example.notesapp.databinding.ActivityMainBinding
import com.example.notesapp.factory.NotesViewmodelFactory
import com.example.notesapp.factory.UserViewmodelFactory
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var viewmodel : NoteViewmodel
    lateinit var textField : AutoCompleteTextView
    lateinit var _binding : ActivityMainBinding
    private val binding get()= _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = _binding.root
        setContentView(view)
        val factory = NotesViewmodelFactory(context = this.applicationContext)
        viewmodel = ViewModelProvider(this,factory)[NoteViewmodel::class.java]

//        val items = listOf("Option 1", "Option 2", "Option 3", "Option 4")
//        val adapter = ArrayAdapter(applicationContext, R.layout.list_item, items)
//        textField = findViewById(R.id.bb)
//        textField.setAdapter(adapter)
    }
}