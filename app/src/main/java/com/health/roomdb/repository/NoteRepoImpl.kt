package com.health.roomdb.repository

import androidx.lifecycle.LiveData
import com.health.roomdb.db.NoteDao
import com.health.roomdb.model.Note
import kotlinx.coroutines.flow.Flow

class NoteRepoImpl(private val noteDao : NoteDao) : NoteRepo {

    override suspend fun addNote(noteItem: Note) {
        noteDao.addNote(noteItem)
    }

    override fun getAllNotes(): Flow<List<Note>> {
        return noteDao.getAllNotes()
    }
}