package com.pardeep.recycler_crud_assignment

import android.content.Context
import androidx.room.Database
import androidx.room.Room

object DBHandler {
    fun getDB(context: Context) : DataBase{
        return Room.databaseBuilder(
            context,
            DataBase::class.java,
            "DataBase")
            .allowMainThreadQueries()
            .build()
    }

}