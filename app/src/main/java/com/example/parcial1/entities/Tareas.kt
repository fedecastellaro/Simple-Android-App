package com.example.parcial1.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.parcial1.R

@Entity(tableName = "tareas")
class Tareas(nombre: String, heading: Int)
{
    @PrimaryKey
    @ColumnInfo(name = "nombre")
    var nombre: String = ""

    @ColumnInfo(name = "heading")
    var heading: Int = R.drawable.todo

    init{
        this.nombre = nombre!!
        this.heading = heading!!
    }
}