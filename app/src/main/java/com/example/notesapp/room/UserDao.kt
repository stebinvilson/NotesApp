package com.example.notesapp.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notesapp.Model.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(usr : UserEntity)

    @Delete
    suspend fun delete(user : UserEntity)

    @Query("delete from User_data")
    suspend fun deleteAllUsers()

    @Query("select * from User_data")
    fun getAll() : LiveData<List<UserEntity>>

    @Query("SELECT * FROM User_data WHERE name LIKE :userName and password LIKE :password")
    suspend fun getUser(userName: String,password : String): UserEntity

}