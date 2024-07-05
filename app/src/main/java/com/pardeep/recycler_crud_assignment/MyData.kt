package com.pardeep.recycler_crud_assignment

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class MyData (
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    var title : String?="",
    var description : String?="",
)
