package com.example.notesapp.Ui.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.notesapp.R
import com.example.notesapp.factory.UserViewmodelFactory
import com.example.notesapp.Viewmodels.UserViewmodel


class LoginActivity : AppCompatActivity() {

private lateinit var viewmodel : UserViewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val factory = UserViewmodelFactory(context = this.applicationContext)
        viewmodel = ViewModelProvider(this,factory)[UserViewmodel::class.java]
    }
}