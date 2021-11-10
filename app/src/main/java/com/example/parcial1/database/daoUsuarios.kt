package com.example.parcial1.database

import androidx.room.*
import com.example.parcial1.entities.Usuarios

//DAO = DATA ACCESS OBJECT
//Más info : https://developer.android.com/codelabs/kotlin-android-training-room-database#4

@Dao
public interface daoUsuarios
{
    @Query("SELECT * FROM users ORDER BY id") // esto significa que seleccione de la tabla USER y ordenado por ID
    fun loadAllPersons(): MutableList<Usuarios?>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPerson(user: Usuarios?)

    @Update
    fun updatePerson(user: Usuarios?)

    @Delete
    fun delete(user: Usuarios?)

    @Query("SELECT * FROM users WHERE id = :id") // Trae todos los usuario que cumplan con el ID
    fun loadPersonById(id: Int): Usuarios?

}

