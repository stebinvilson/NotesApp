package com.example.notesapp.Repository

import androidx.lifecycle.MutableLiveData
import com.example.notesapp.room.UserDao
import com.example.notesapp.Model.UserEntity

class UserRepository(private val dao: UserDao) {

val tt : MutableLiveData<UserEntity> = MutableLiveData()
    var data = dao.getAll()

    suspend fun addUser(user: UserEntity){
        dao.insert(user)
    }

    suspend fun loggeduser(username: String, password: String) : UserEntity {
        var data  = dao.getUser(username,password)
        return data
    }
}