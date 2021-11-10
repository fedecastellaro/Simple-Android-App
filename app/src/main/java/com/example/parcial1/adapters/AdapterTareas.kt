package com.example.parcial1.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial1.R
import com.example.parcial1.entities.Tareas
import com.example.parcial1.fragments.listTareas
import com.google.android.material.internal.ContextUtils.getActivity
import java.security.AccessController.getContext


class AdapterTareas(
    private var TareasList: MutableList<Tareas>,
    var clicklistenerfunciones: listTareas,
    var context : Context
): RecyclerView.Adapter<AdapterTareas.TareasHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TareasHolder
    {
        //tengo que ir a buscar el xml de los items de la tarea
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.items_tareas,parent,false)
        return (AdapterTareas.TareasHolder(view))
    }

    override fun getItemCount(): Int {
        return TareasList.size
    }

    override fun onBindViewHolder(holder: TareasHolder, position: Int)
    {
        var color: String?
        var letras: String?
        val Prefs = PreferenceManager.getDefaultSharedPreferences(context)

        color = Prefs.getBoolean("modoCards", false).toString()
        letras= Prefs.getBoolean("modoLetters", false).toString()

        if (color == "true") holder.getCardLayout().setCardBackgroundColor(Color.RED)
        else holder.getCardLayout().setCardBackgroundColor(Color.WHITE)

        if (letras == "true") holder.getTextLayout().setTextColor(Color.GREEN)
        else holder.getTextLayout().setTextColor(Color.BLACK)

        holder.setName(TareasList[position].nombre)
        holder.setImage(TareasList[position].heading)

         holder.getCardLayout().setOnClickListener {
             //esta es la funcion que le mando desde el fragment
            clicklistenerfunciones.onItemClick(position)
        }

        holder.getCardLayout().setOnLongClickListener{
             clicklistenerfunciones.onLongItemClick(position)
            return@setOnLongClickListener true
        }

    }

    class TareasHolder(v: View): RecyclerView.ViewHolder(v)
    {
        // Acá tengo que setear todas las caracteristicas de c/item de mi lista ( imagen, texto, botones, etc)
        private var view: View
        init{
            this.view = v
        }
        fun setName(name: String) {
            val txt: TextView = view.findViewById(R.id.txt_name_item)
            txt.text = name
        }

        fun getCardLayout (): CardView {
            return view.findViewById(R.id.card_package_item)
        }

        fun setImage(heading: Int) {
            val img: ImageView = view.findViewById(R.id.img_item)
            img.setImageResource(heading)
        }
        fun getTextLayout(): TextView{
            return view.findViewById(R.id.txt_name_item)
        }
    }

}