package com.mvvm.flows.data.names

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NamesDao {
    @Query("SELECT * FROM Names")
    fun getNames(): List<Names>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(videos: List<Names>)
}