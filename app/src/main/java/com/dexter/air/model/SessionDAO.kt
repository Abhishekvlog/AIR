package com.dexter.air.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SessionDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun register(sessionEntity: SessionEntity)

    @Query("Select * from session_table")
    fun addSession(date: String, session: String): SessionEntity

    @Query("Select * from session_table")
    fun getData(sessionEntity: SessionEntity)
}