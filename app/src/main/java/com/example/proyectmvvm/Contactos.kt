package com.example.proyectmvvm

import androidx.room.Entity
import androidx.room.PrimaryKey


//Tabla Contactos
@Entity(tableName = "Contactos")
class Contactos(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var nombre: String,
    var numero: String
)
