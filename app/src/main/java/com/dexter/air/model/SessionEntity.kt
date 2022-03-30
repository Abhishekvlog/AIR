package com.dexter.air.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "session_table")
data class SessionEntity(
    @ColumnInfo(name = "Date") var date :String,
    @ColumnInfo(name = "Session") var session :String,
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id : Int = 0
}