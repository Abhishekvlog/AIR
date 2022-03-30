package com.dexter.air.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SessionEntity::class], version = 1)
abstract class SessionDatabase : RoomDatabase() {
    abstract fun getSessionDAO() : SessionDAO

    companion object {
        private var instance: SessionDatabase? = null
        fun getSessionDatabase(context: Context): SessionDatabase {
            if (instance != null) {
                return instance!!
            } else {
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    SessionDatabase::class.java,
                    "session_db"
                )
                builder.fallbackToDestructiveMigration()
                instance = builder.build()
            }
            return instance!!
        }
    }
}