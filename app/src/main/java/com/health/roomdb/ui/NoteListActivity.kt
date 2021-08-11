package com.health.roomdb.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.health.roomdb.MyApplication
import com.health.roomdb.R
import com.health.roomdb.model.Note
import com.health.roomdb.viewmodels.NoteListViewModel
import com.health.roomdb.viewmodels.ViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_main.*

class NoteListActivity : AppCompatActivity() {

    lateinit var viewModel: NoteListViewModel
    var adapter = NotesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpViewModel()
        setUpView()
    }

    private fun setUpView() {

        rv_notes.layoutManager = LinearLayoutManager(this)
        rv_notes.adapter = adapter

        viewModel.notesList.observe(this, { notesList ->
            notesList?.let {
                Log.d("@@Data", it.size.toString())
                adapter.setData(it)
            }
        })

        button_add.setOnClickListener {
            if (title_input.text.toString().isNotEmpty() && message_input.toString().isNotEmpty()) {
                viewModel.addNote(
                    Note(
                        title = title_input.text.toString(),
                        message = message_input.text.toString(),
                    )
                )
                title_input.text?.clear()
                message_input.text?.clear()

                val imm: InputMethodManager =
                    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(it.windowToken, 0)


            } else {
                Toast.makeText(this, "Please enter data first", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun setUpViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelProviderFactory((application as MyApplication).repository)
        ).get(NoteListViewModel::class.java)
    }
}