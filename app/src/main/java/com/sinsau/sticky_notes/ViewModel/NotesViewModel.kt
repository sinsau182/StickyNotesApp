package com.sinsau.sticky_notes.ViewModel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.sinsau.sticky_notes.Database.NotesDatabase
import com.sinsau.sticky_notes.Model.Notes
import com.sinsau.sticky_notes.Repository.NotesRepository

class NotesViewModel(application: Application) : AndroidViewModel(application) {

    val repository: NotesRepository

    init {
        val dao = NotesDatabase.getDatabaseInstance(application).myNotesDao()
        repository = NotesRepository(dao)
    }

    fun addNotes(notes: Notes) {
        repository.insertNotes(notes)
    }

    fun getNotes(): LiveData<List<Notes>> = repository.getAllNotes()

    fun getHighNotes(): LiveData<List<Notes>> =  repository.getHighNotes()
    fun getMediumNotes(): LiveData<List<Notes>> =  repository.getMediumNotes()
    fun getLowNotes(): LiveData<List<Notes>> =  repository.getLowNotes()

    fun deleteNotes(id: Int) {
        repository.deleteNotes(id)
    }

    fun updateNotes(notes: Notes) {
        repository.updateNotes(notes)
    }

}