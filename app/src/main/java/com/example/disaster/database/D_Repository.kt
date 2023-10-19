package com.example.disaster.database

// Repository class responsible for managing data interactions
class D_Repository (private val db: D_Database){
    // Insert a new disaster into the database
    suspend fun insert(disaster: Disaster) = db.getDisasterDao().insert(disaster)
    // Delete a disaster from the database
    suspend fun delete(disaster: Disaster) = db.getDisasterDao().delete(disaster)
    // Retrieve all disaster entries from the database
    fun getAllDisaster():List<Disaster> = db.getDisasterDao().getAllDisaster()
}