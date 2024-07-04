package com.pardeep.recycler_crud_assignment

import androidx.room.Dao
import androidx.room.Insert

@Dao

interface ToDoInterface {
    @Insert
    fun insertTodo(myData: MyData)
}