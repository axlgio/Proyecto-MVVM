package com.example.proyectmvvm

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectmvvm.databinding.ContactoLayoutBinding

class ContactoAdaptador(val context: Context, val list: List<Contactos>) :
    RecyclerView.Adapter<ContactoAdaptador.ViewHolder>() {
    //Clase ViewHolder interior RecyclerView
    class ViewHolder(val binding: ContactoLayoutBinding) : RecyclerView.ViewHolder(binding.root) {}

    //Instacia de Dao con ContactoDataBase
    private val dao = ContactoDataBase.getDatabaseInstance(context).ContactoDao()

    // Funcion que infla el layout con el contacto y la creacion de una nueva instacia con el ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ContactoLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    //función para vincular los datos a los elementos de vista de ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.contactoNombre.text = list[position].nombre
        holder.binding.contactoNumero.text = list[position].numero
        // borrar con el boton en el setOnClickListener depende en que posicion se presione
        holder.binding.buttonBorrar.setOnClickListener {
            dao.borrarContacto(list[position])
            notifyItemRemoved(position)
        }

    }

    // funcion que retorna los numeros de la lista de los item
    override fun getItemCount(): Int {
        return list.size
    }
}
