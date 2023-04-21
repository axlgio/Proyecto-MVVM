package com.example.proyectmvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.proyectmvvm.databinding.ActivityCrearContactoBinding

class Crear_Contacto_Activity : AppCompatActivity() {


    private lateinit var binding: ActivityCrearContactoBinding

    //variable con acceso al Contacto a ViewModel
    val viewModel: ContactoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Infla el Loyout para tener acceso a la vista
        binding = ActivityCrearContactoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //SetOnClickListener que guarda el contacto
        binding.guardar.setOnClickListener {
            createContact(it)
        }

    }

    // Funcion que crea un nuevo contacto
    private fun createContact(it: View?) {
        // lee el nombre y numero de telefono del EditTexts
        val nombre = binding.etName.text.toString()
        val numero = binding.etNumber.text.toString()

        // crea un nuevo contacto Objecto
        val data = Contactos(null, nombre = nombre, numero = numero)

        // llama ViewModel para poder acceder al Agregar Contacto y asi guardar el objeto anteriormente creado
        viewModel.AgregarContacto(data)

        //Notificacion de confirmacion de que el Contacto fue guardado con exito
        Toast.makeText(this@Crear_Contacto_Activity, "Contacto Guardado", Toast.LENGTH_SHORT).show()

        //Iniciar Actividad
        startActivity(Intent(this@Crear_Contacto_Activity, MainActivity::class.java))
    }

}