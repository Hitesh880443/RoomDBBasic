package com.health.roomdb.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.health.roomdb.model.Note
import com.health.roomdb.repository.NoteRepo
import kotlinx.coroutines.launch

class NoteListViewModel(private val noteRepo: NoteRepo) : ViewModel() {

    val notesList: LiveData<List<Note>> = noteRepo.getAllNotes().asLiveData()

    fun addNote(noteItem: Note) {
        viewModelScope.launch {
            noteRepo.addNote(noteItem)
        }
    }
}