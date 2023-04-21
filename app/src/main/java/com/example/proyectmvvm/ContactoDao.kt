package com.example.proyectmvvm

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactoDao {

    //Consulta para ver todos los Contactos
    @Query("Select * from Contactos")
    fun verTodosLosContactos(): LiveData<List<Contactos>>

    //"Consulta" para Insertar un nuevo contacto
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertarContacto(Contactos: Contactos)

    //"Consulta" para borrar un contacto
    @Delete
    fun borrarContacto(Contactos: Contactos)

}