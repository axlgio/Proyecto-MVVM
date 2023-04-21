package com.example.proyectmvvm

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Contactos::class], version = 1, exportSchema = false)
abstract class ContactoDataBase : RoomDatabase() {


    abstract fun ContactoDao(): ContactoDao

    companion object {
        @Volatile
        var INSTANCE: ContactoDataBase? = null


        fun getDatabaseInstance(context: Context): ContactoDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val roomDatabaseInstance =
                    Room.databaseBuilder(context, ContactoDataBase::class.java, "Contactos")
                        .allowMainThreadQueries().build()
                INSTANCE = roomDatabaseInstance
                return roomDatabaseInstance
            }
        }

    }

}

