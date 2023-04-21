package com.example.proyectmvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Variable privada para inflar la vista del activity
    private lateinit var binding: ActivityMainBinding

    // Variable para tener acceso al ViewModels
    val viewModel: ContactoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Variale para inflar la visra y asi con el bidding llamar cualquier cosa de la vista
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //onClickListener con boton flotante para llamar la actividad crear contacto
        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, Crear_Contacto_Activity::class.java)
            startActivity(intent)
        }

        // poder observar los datos que vienen del objeto vercontactos (practicamente corriendo la lista)
        viewModel.VerContactos().observe(this, Observer { list ->
            // set the layout manager and the adapter for the recycler view
            binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
            binding.recyclerView.adapter = ContactoAdaptador(this, list)
        })
    }
}