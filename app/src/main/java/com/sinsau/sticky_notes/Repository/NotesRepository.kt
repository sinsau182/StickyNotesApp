package com.sinsau.sticky_notes.Repository

import androidx.lifecycle.LiveData
import com.sinsau.sticky_notes.Dao.NotesDao
import com.sinsau.sticky_notes.Model.Notes

class NotesRepository(val dao: NotesDao) {

    fun getAllNotes(): LiveData<List<Notes>> =  dao.getNotes()

    fun getHighNotes(): LiveData<List<Notes>> =  dao.getHighNotes()
    fun getMediumNotes(): LiveData<List<Notes>> =  dao.getMediumNotes()
    fun getLowNotes(): LiveData<List<Notes>> =  dao.getLowNotes()

    fun insertNotes(notes: Notes) {
        dao.insertNotes(notes)
    }

    fun deleteNotes(id:Int){
        dao.deleteNotes(id)
    }

    fun updateNotes(notes: Notes) {
        dao.updateNotes(notes)
    }

}