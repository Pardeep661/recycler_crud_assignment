package com.pardeep.recycler_crud_assignment

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface DataDao {

    @Insert
    fun insertData(myData: MyData)

    @Query("Select * from 'MyData'")
    fun getAllData() : List<MyData>

}