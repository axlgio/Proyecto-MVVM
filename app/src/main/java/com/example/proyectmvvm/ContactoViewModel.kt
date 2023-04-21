package com.example.proyectmvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class ContactoViewModel(application: Application) : AndroidViewModel(application) {
    val repository: ContactoRepositorio

    init {
        val dao = ContactoDataBase.getDatabaseInstance(application).ContactoDao()
        repository = ContactoRepositorio(dao)
    }

    fun AgregarContacto(Contactos: Contactos) {
        repository.insertarContacto(Contactos)
    }

    fun VerContactos(): LiveData<List<Contactos>> = repository.verContactos()

}

