package com.example.parcial1.view

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.parcial1.database.appDatabase
import com.example.parcial1.database.daoUsuarios
import com.example.parcial1.entities.Usuarios

import com.example.parcial1.fragments.Login


class LoginViewModel(app: Application): AndroidViewModel(app){
    private var db: appDatabase? = appDatabase.getAppDataBase(getApplication())
    private var userDao: daoUsuarios? = db?.userDao()

    lateinit var  allUsers : MutableLiveData<List<Usuarios>>

    var i: Int = 0

    init {
        allUsers = MutableLiveData()

        if(!searchPerson(Usuarios("admin","-","admin",0)))
            insertPersonInfo(Usuarios("admin","admin","admin",0))

        i = getUserCount()
    }


    fun insertPersonInfo(entity: Usuarios){
        userDao?.insertPerson(entity)
    }

    fun searchPerson(entity: Usuarios) : Boolean{
        var list = userDao?.loadAllPersons() as MutableList<Usuarios>

        var usuarioFounded = list.find { it.name == entity.name }

        if (usuarioFounded == null)
        {
            Log.d("Database", "Usuario no encontrado")
            return false
        }
        else
        {
            if( usuarioFounded.password == entity.password)
            {
                Log.d("Database", "Usuario encontrado")
                return true
            }
        }
        return false
    }


    fun updateUserInfo(entity: Usuarios){
        val userDao = appDatabase.getAppDataBase(getApplication())?.userDao()
        userDao?.updatePerson(entity)

    }

    fun deleteUserInfo(entity: Usuarios):Boolean{
        var list = userDao?.loadAllPersons() as MutableList<Usuarios>

        var usuarioFounded: Usuarios? = list.find { it.name == entity.name } ?: return false

        userDao?.delete(usuarioFounded)

        return true
    }
    fun getUserCount():Int{
        var list = userDao?.loadAllPersons() as MutableList<Usuarios>
        return list.size
    }
}