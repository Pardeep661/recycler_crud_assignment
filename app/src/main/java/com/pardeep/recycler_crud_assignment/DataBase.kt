package com.pardeep.recycler_crud_assignment

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MyData::class],
    version = 1,
    exportSchema = true
)
abstract class DataBase : RoomDatabase() {

    abstract val dataDao : DataDao


}