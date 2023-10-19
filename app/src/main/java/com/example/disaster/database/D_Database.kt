package com.example.disaster.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Disaster::class], version = 1)
abstract class D_Database:RoomDatabase(){
    // Abstract function to get the Data Access Object (DAO) for Disaster entities
    abstract fun getDisasterDao(): D_Dao

    companion object{
        @Volatile
        private var INSTANCE: D_Database?=null

        // Create a singleton instance of the database
        fun getInstance(context:Context): D_Database {
            synchronized(this){
                return INSTANCE ?:Room.databaseBuilder(
                    context,
                    D_Database::class.java,
                    "Disaster_db"
                ).fallbackToDestructiveMigration().build().also {
                    INSTANCE =it
                }
            }
        }
    }

}