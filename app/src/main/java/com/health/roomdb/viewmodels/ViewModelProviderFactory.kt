package com.health.roomdb.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.health.roomdb.repository.NoteRepo

class ViewModelProviderFactory(private val repo: NoteRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteListViewModel::class.java)) {
            return NoteListViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}