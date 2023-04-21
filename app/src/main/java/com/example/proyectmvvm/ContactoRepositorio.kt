package com.example.proyectmvvm

import androidx.lifecycle.LiveData

class ContactoRepositorio(val dao: ContactoDao) {

    //Funcion para ver todos los contactos
    fun verContactos(): LiveData<List<Contactos>> {
        return dao.verTodosLosContactos()
    }

    // funcion para insertar en la base de datos
    fun insertarContacto(Contactos: Contactos) {
        dao.insertarContacto(Contactos)
    }

    //funcion parar borrar de la base de datos
    fun borrarContacto(Contactos: Contactos) {
        dao.borrarContacto(Contactos)
    }
}
