package com.example.parcial1.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class Usuarios (name: String, email: String, password: String, id : Int)
{
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int = 0

    @ColumnInfo(name = "name")
    var name: String = ""

    @ColumnInfo(name = "email")
    var email: String = ""

    @ColumnInfo(name = "password")
    var password: String = ""

    init{
        this.email = email!!
        this.name = name!!
        this.password = password!!
        this.id = id!!
    }
}