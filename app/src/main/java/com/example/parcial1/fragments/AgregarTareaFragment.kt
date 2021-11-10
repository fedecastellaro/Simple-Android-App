package com.example.parcial1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.parcial1.R
import com.example.parcial1.entities.Tareas
import com.example.parcial1.view.TareasViewModel
import kotlinx.android.synthetic.main.fragment_agregar_tarea.*



class AgregarTareaFragment() : Fragment(R.layout.fragment_agregar_tarea) {

    lateinit var viewModelTareas: TareasViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelTareas = ViewModelProvider(requireActivity()).get(TareasViewModel::class.java)


    }
    override fun onStart() {
        super.onStart()

        buttonOK.setOnClickListener {
            if (editTextTextPersonName.text.isNotEmpty()) {
                viewModelTareas.setNewTarea(Tareas(editTextTextPersonName.text.toString(), R.drawable.todo))
            }
        }
    }
}