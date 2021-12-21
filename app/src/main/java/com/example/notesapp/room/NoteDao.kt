package com.example.notesapp.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notesapp.Model.Note
import com.example.notesapp.Model.UserEntity

@Dao()
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note : Note)

    @Delete
    suspend fun delete(note : Note)

    @Query("delete from Note_table")
    suspend fun deleteAllNotes()

    @Query("select * from Note_table")
    fun getAll() :List<Note>

    @Update()
    suspend fun updateNote(note : Note)
}