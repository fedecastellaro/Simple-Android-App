package com.example.parcial1.fragments

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.provider.Settings.System.getConfiguration
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial1.R
import com.example.parcial1.adapters.AdapterTareas
import com.example.parcial1.view.TareasViewModel
import kotlinx.android.synthetic.main.items_tareas.*


class listTareas : Fragment() {

        lateinit var vLista: View
        lateinit var bottonAdd: Button

        lateinit var recycleTareas : RecyclerView
        private lateinit var linearLayoutManager: LinearLayoutManager

        private lateinit var tareasListAdapter: AdapterTareas
        lateinit var viewModelTareas: TareasViewModel

        var theme: String = ""

    interface  listenerclicks{
            fun onItemClick(pos: Int)
            fun onLongItemClick(pos: Int)
        }

    companion object {
        fun newInstance() = listTareas()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {

            vLista =  inflater.inflate(R.layout.fragment_list_tareas, container, false)
            recycleTareas = vLista.findViewById(R.id.rec_tareas)

            viewModelTareas = ViewModelProvider(requireActivity()).get(TareasViewModel::class.java)

            bottonAdd = vLista.findViewById(R.id.buttonAdd)
            tareasListAdapter = AdapterTareas(viewModelTareas.getListaTareas(), this, requireContext())

            return vLista
        }

        override fun onActivityCreated(savedInstanceState: Bundle?) {
            super.onActivityCreated(savedInstanceState)

        }

        override fun onStart() {
            super.onStart()

            recycleTareas.setHasFixedSize(true)
            linearLayoutManager = LinearLayoutManager(context)
            recycleTareas.layoutManager = linearLayoutManager
            recycleTareas.adapter = tareasListAdapter


            viewModelTareas.allTareas.observe(viewLifecycleOwner, Observer { listaUpdate ->
                tareasListAdapter = AdapterTareas(viewModelTareas.getListaTareas(), this,requireContext())
                recycleTareas.adapter = tareasListAdapter
            })

            bottonAdd.setOnClickListener {
            val action = listTareasDirections.actionListTareasToAgregarTareaFragment()
            vLista.findNavController().navigate(action)
            }

        }

        fun onItemClick ( position : Int ) {

            var lista = viewModelTareas.getListaTareas()
            var text2Send = "Lista de " + viewModelTareas.getNameTarea(position)

            val action2 = listTareasDirections.actionListTareasToConteinerTabs2(text2Send)
            vLista.findNavController().navigate(action2)

        }

        fun onLongItemClick (position: Int)
        {
            viewModelTareas.removeTarea(position)
        }


    }