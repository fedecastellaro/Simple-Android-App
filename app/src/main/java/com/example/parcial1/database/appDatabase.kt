package com.example.parcial1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.parcial1.entities.Usuarios
import com.example.parcial1.entities.Tareas

@Database(
    entities = [Usuarios::class, Tareas::class],
//    entities = [Usuarios::class],
    version = 1,
    exportSchema = false
)

public  abstract class  appDatabase : RoomDatabase() {
    //agregar todas las tablas abajo de esta.
    abstract fun userDao(): daoUsuarios
    abstract fun tareasDao(): daoTareas

    companion object {
        var INSTANCE: appDatabase? = null

        fun getAppDataBase(context: Context): appDatabase? {
            if (INSTANCE == null) {
                synchronized(appDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        appDatabase::class.java,
                        "myDB"
                    ).allowMainThreadQueries().build() // No es lo mas recomendable que se ejecute en el mainthread
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }
}