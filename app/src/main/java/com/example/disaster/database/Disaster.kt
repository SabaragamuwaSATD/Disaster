package com.example.disaster.database

import androidx.room.Entity
import androidx.room.PrimaryKey

// Entity class representing a disaster entry in the database
@Entity
data class Disaster(
    var title:String?,// The title of the disaster entry
    var place:String?,// The location or place associated with the disaster
    var discription:String?,// A description or details about the disaster
    var photoPath:String?,// Path to the associated image/photo
){
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null// Primary key and auto-generated unique identifier for the disaster entry
}