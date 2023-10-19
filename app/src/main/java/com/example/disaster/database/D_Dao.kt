package com.example.disaster.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface D_Dao {
    // Insert a new disaster record into the database
    @Insert
    suspend fun insert(disaster: Disaster)
    // Delete an existing disaster record from the database
    @Delete
    suspend fun delete(disaster: Disaster)
    // Retrieve all disaster records from the database
    @Query("SELECT * FROM Disaster")
    fun getAllDisaster():List<Disaster>

}