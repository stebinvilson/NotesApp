package com.example.notesapp.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User_data")
data class UserEntity(@PrimaryKey(autoGenerate = false) val id: Int? = null, @ColumnInfo(name = "name")var name : String,
                      @ColumnInfo(name = "email")var email : String,@ColumnInfo(name = "password") var password : String) {


}