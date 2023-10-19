package com.example.disaster

import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.disaster.database.Disaster
import com.bumptech.glide.Glide
// ViewHolder class for displaying disaster items in a RecyclerView
class DisasterViewHolder(view: View) : ViewHolder(view) {
    val Disaster_Image: ImageView = view.findViewById(R.id.DImage)
    val Disaster_Title: TextView = view.findViewById(R.id.Dtitle)
    val Disaster_Place: TextView = view.findViewById(R.id.DDistrict)
    val Disaster_Discription: TextView = view.findViewById(R.id.DDis)
    val Delete_Disaster:ImageView = view.findViewById(R.id.deleteButton)

    // Binds data from a Disaster object to the ViewHolder
    fun bind(disaster: Disaster) {
        Disaster_Title.text = disaster.title
        Disaster_Place.text = disaster.place
        Disaster_Discription.text = disaster.discription


        // Load and display the image using Glide
        disaster.photoPath?.let { path ->
            Glide.with(Disaster_Image.context)
                .load(Uri.parse(path)) // Assuming the photoPath is a valid URI
                .into(Disaster_Image)
        }
    }

}