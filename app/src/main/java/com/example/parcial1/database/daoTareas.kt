package com.example.parcial1.database

import androidx.room.*
import com.example.parcial1.entities.Tareas
import com.example.parcial1.entities.Usuarios

//DAO = DATA ACCESS OBJECT
//Más info : https://developer.android.com/codelabs/kotlin-android-training-room-database#4

@Dao
public interface daoTareas
{
    @Query("SELECT * FROM tareas ORDER BY nombre") // esto significa que seleccione de la tabla USER y ordenado por ID
    fun loadAllTareas(): MutableList<Tareas?>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTareas(user: Tareas?)

    @Update
    fun updateTareas(user: Tareas?)

    @Delete
    fun delete(user: Tareas?)

}

