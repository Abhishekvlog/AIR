package com.dexter.air.model.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addData(sessionEntity: SessionEntity)

    @Query("select * from session_table limit :days")
    fun getData(days: Int): LiveData<List<SessionEntity>>
}