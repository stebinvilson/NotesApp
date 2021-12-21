package com.example.notesapp.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notesapp.Viewmodels.UserViewmodel
import java.lang.IllegalArgumentException

class UserViewmodelFactory(private val context : Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(UserViewmodel::class.java)) {
                return UserViewmodel( context =context ) as T
            }
        throw IllegalArgumentException("Unknown view model class")
    }
}
