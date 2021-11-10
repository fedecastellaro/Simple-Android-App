package com.example.parcial1.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.parcial1.R
import com.example.parcial1.adapters.AdapterTareas
import com.example.parcial1.database.appDatabase
import com.example.parcial1.database.daoTareas
import com.example.parcial1.database.daoUsuarios
import com.example.parcial1.entities.Tareas
import com.example.parcial1.entities.Usuarios


class TareasViewModel(app: Application): AndroidViewModel(app){

    private var db: appDatabase? = appDatabase.getAppDataBase(getApplication())
    private var tareasDao: daoTareas? = db?.tareasDao()

    lateinit var allTareas : MutableLiveData<List<Tareas>>
    var tareas : MutableList<Tareas> = ArrayList<Tareas>()

    private lateinit var tareasListAdapter: AdapterTareas

    init {
        allTareas = MutableLiveData()

        setNewTarea(Tareas("Trámites", R.drawable.tramite))
        setNewTarea(Tareas("Exámenes", R.drawable.examen))
        setNewTarea(Tareas("Tareas",   R.drawable.tareas))

        setTareasData()
    }

    fun getAllUsersObservers():MutableLiveData<List<Tareas>>{
        return allTareas
    }

    fun setTareasData(){
        allTareas.value = tareasDao?.loadAllTareas() as MutableList<Tareas>

    }

    fun setNewTarea(nuevaTarea: Tareas)
    {
        tareasDao?.insertTareas(nuevaTarea)
        setTareasData()
    }

    fun getListaTareas(): MutableList<Tareas>{
        return tareasDao?.loadAllTareas() as MutableList<Tareas>
    }

    fun removeTarea(position: Int){

        var listaTar = tareasDao?.loadAllTareas() as MutableList<Tareas>
        var tarea = listaTar.elementAt(position)

        tareasDao?.delete(tarea)
        setTareasData()
    }

    fun getNameTarea(position: Int): String{
        var listaTar = tareasDao?.loadAllTareas() as MutableList<Tareas>
        return listaTar.elementAt(position).nombre
    }
}
