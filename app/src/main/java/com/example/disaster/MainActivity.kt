package com.example.disaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get a reference to the "Add Disaster" button
        var addDisasterButton: Button = findViewById(R.id.addDisasterBtn)
        // Set a click listener to navigate to the "AddDisasters" activity
        addDisasterButton.setOnClickListener {
            var intent = Intent(this, AddDisasters::class.java)
            startActivity(intent)
        }

        // Get a reference to the "Emergency Contacts" button
        var Emergency_Contact_Button: Button = findViewById(R.id.contactBtn)
        // Set a click listener to navigate to the "Emergency_Calls" activity
        Emergency_Contact_Button.setOnClickListener {
            var intent = Intent(this, Emergency_Calls::class.java)
            startActivity(intent)
        }

    }
}