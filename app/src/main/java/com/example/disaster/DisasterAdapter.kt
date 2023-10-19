package com.example.disaster

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.disaster.database.Disaster
import com.example.disaster.database.D_Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DisasterAdapter(items: List<Disaster>, repository: D_Repository, viewMode: MainActivityData) :
    RecyclerView.Adapter<DisasterAdapter.DisasterViewHolder>() {
    lateinit var context: Context

    // The list of disaster items
    val item_new = items

    // Reference to the data repository
    val repository_new = repository

    // Reference to the view model
    val viewModel_new = viewMode

    inner class DisasterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val Disaster_Title = itemView.findViewById<TextView>(R.id.Dtitle)
        val Disaster_Place = itemView.findViewById<TextView>(R.id.DDistrict)
        val Disaster_Discription = itemView.findViewById<TextView>(R.id.DDis)
        val Disaster_Image = itemView.findViewById<ImageView>(R.id.DImage)
        val deleteButton = itemView.findViewById<ImageButton>(R.id.deleteButton)

        init {
// Set a click listener for the delete button
            deleteButton.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val disaster = item_new[position]

                    // Handle the delete process here
                    CoroutineScope(Dispatchers.IO).launch {
                        repository_new.delete(disaster)
                    }
                    // Remove the deleted item from the list
                    item_new.toMutableList().removeAt(position)
                    // Notify the adapter about the removal
                    notifyItemRemoved(position)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisasterViewHolder {
        // Inflate the view for each item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.disaster_viewer, parent, false)
        return DisasterViewHolder(view)
    }

    override fun getItemCount(): Int {
        // Return the number of disaster items
        return item_new.size
    }

    override fun onBindViewHolder(holder: DisasterViewHolder, position: Int) {
        // Bind the data to the view elements
        val disaster = item_new[position]
        holder.Disaster_Title.text = disaster.title
        holder.Disaster_Place.text = disaster.place
        holder.Disaster_Discription.text = disaster.discription
        holder.Disaster_Image


    }
    }
