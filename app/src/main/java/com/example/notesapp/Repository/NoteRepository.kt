package com.example.notesapp.Repository

import com.example.notesapp.Model.Note
import com.example.notesapp.room.NoteDao

class NoteRepository(private val noteDao: NoteDao) {

    suspend fun addnote(note: Note) {

        noteDao.insert(note)
    }

    suspend fun updatenote(note: Note) {
        noteDao.updateNote(note)
    }

    suspend fun getAllNotes() : List<Note>{
       val notes = noteDao.getAll()
        return notes
    }


}