package com.health.roomdb.repository

import androidx.lifecycle.LiveData
import com.health.roomdb.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepo {
    suspend fun addNote(noteItem: Note)
    fun getAllNotes(): Flow<List<Note>>
}