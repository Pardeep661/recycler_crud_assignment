package com.pardeep.recycler_crud_assignment

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface DataDao {

    @Insert
    fun insertData(myData: MyData)

   @Query("Select * from 'MyData'")
   fun getAllData() : List<MyData>

   @Update
   fun updateData(myData: MyData)


   @Delete
   fun deleteData(myData: MyData)



}