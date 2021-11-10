package com.example.parcial1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial1.R

//class TramitesAdapter(
//    private var tramitesList: MutableList<Tramites>) : RecyclerView.Adapter<TramitesAdapter.TramitesHolder>()
//{
//
//
//    class TramitesHolder(v: View): RecyclerView.ViewHolder(v)
//    {
//        // Acá tengo que setear todas las caracteristicas de c/item de mi lista ( imagen, texto, botones, etc)
//        private var view: View
//        init{
//            this.view = v
//        }
//        fun setName(name: String) {
//            val txt: TextView = view.findViewById(R.id.txt_name_item)
//            txt.text = name
//        }
//
//        fun getCardLayout (): CardView {
//            return view.findViewById(R.id.card_package_item)
//        }
//
//
//    }
//
//    override fun onBindViewHolder(holder: TramitesHolder, position: Int) {
//        holder.setName(tramitesList[position].nombre)
//        holder.getCardLayout()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TramitesHolder {
//        val view =  LayoutInflater.from(parent.context).inflate(R.layout.items_tareas,parent,false)
//        return (TramitesAdapter.TramitesHolder(view))
//    }
//
//    override fun getItemCount(): Int {
//        return tramitesList.size
//    }
//
//
//}