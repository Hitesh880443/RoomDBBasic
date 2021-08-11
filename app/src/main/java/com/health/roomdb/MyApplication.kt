package com.health.roomdb

import android.app.Application
import com.health.roomdb.db.NoteDataBase
import com.health.roomdb.repository.NoteRepoImpl

class MyApplication : Application() {

    val database by lazy { NoteDataBase.getDatabase(this) }
    val repository by lazy { NoteRepoImpl(database.noteDao()) }
}