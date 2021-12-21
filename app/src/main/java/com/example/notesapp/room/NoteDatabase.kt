package com.example.notesapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.notesapp.Model.Note
import com.example.notesapp.Model.UserEntity

@Database(entities = arrayOf(UserEntity::class,Note::class), version = 2)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun userdao(): UserDao
    abstract fun notedao() : NoteDao

    companion object {
        private var instance: NoteDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): NoteDatabase {
            if (instance == null)
                instance = Room.databaseBuilder(
                    ctx.applicationContext, NoteDatabase::class.java,
                    "note_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build()

            return instance!!
        }

        private val roomCallback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

            }
        }
    }
}