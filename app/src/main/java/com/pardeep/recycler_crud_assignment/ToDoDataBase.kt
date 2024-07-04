package com.pardeep.recycler_crud_assignment

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ToDoInterface::class], version = 1, exportSchema = true)
abstract class TodoDataBase : RoomDatabase() {

    abstract fun todoInterface() : ToDoInterface

    // we have static member and function of class
    companion object{
        private var toDoDataBase : TodoDataBase? = null

        fun getInstance(context: Context) : TodoDataBase {
            if (toDoDataBase == null){
                toDoDataBase = Room.databaseBuilder(context,TodoDataBase::class.java,"TodoDatabase").allowMainThreadQueries().build()
            }
            return toDoDataBase!!
        }

    }
}