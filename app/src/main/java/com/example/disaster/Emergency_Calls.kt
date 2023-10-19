package com.example.disaster

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

// Emergency_Calls class for handling emergency call actions
class Emergency_Calls : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.emergency)

        // Buttons for various emergency actions
        val callAmbulanceButton: Button = findViewById(R.id.callAmbulanceButton)
        val firstAidTipButton: Button = findViewById(R.id.firstAidTipButton)
        val callPoliceButton: Button = findViewById(R.id.callPoliceButton)
        val weatherButton: Button = findViewById(R.id.weatherNewsButton)
        val callDoctorButton: Button = findViewById(R.id.callDoctorButton)
        val medical: Button = findViewById(R.id.medicalWebButton)
        val callFireButton: Button = findViewById(R.id.callFireButton)

        // Click listener for calling the fire department
        callFireButton.setOnClickListener {
            val number = "1111"
            val uri = Uri.parse(String.format("tel:$number"))
            val intent = Intent()
            intent.action = Intent.ACTION_DIAL
            intent.data = uri
            startActivity(intent)
        }

        // Click listener for calling the police
        callPoliceButton.setOnClickListener {
            val number = "1112"
            val uri = Uri.parse(String.format("tel:$number"))
            val intent = Intent()
            intent.action = Intent.ACTION_DIAL
            intent.data = uri
            startActivity(intent)
        }

        // Click listener for calling an ambulance
        callAmbulanceButton.setOnClickListener {
            val number = "1113"
            val uri = Uri.parse(String.format("tel:$number"))
            val intent = Intent()
            intent.action = Intent.ACTION_DIAL
            intent.data = uri
            startActivity(intent)
        }

        // Click listener for calling a doctor
        callDoctorButton.setOnClickListener {
            val number = "1114"
            val uri = Uri.parse(String.format("tel:$number"))
            val intent = Intent()
            intent.action = Intent.ACTION_DIAL
            intent.data = uri
            startActivity(intent)
        }

        // Click listener for opening a first aid tips website
        medical.setOnClickListener {

            val url = "https://www.verywellhealth.com/basic-first-aid-procedures-1298578"
            val uri = Uri.parse(url)
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.data = uri
            startActivity(intent)

        }

        // Click listener for opening a first aid tips website
        firstAidTipButton.setOnClickListener {

            val url = "https://www.ready.gov/home-fires"
            val uri = Uri.parse(url)
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.data = uri
            startActivity(intent)

        }

        // Click listener for checking weather news
        weatherButton.setOnClickListener {
            val url =
                "https://search.yahoo.com/search;_ylt=Awr98ioDUi1lPlg5udRXNyoA;_ylc=X1MDMjc2NjY3OQRfcgMyBGZyA21jYWZlZQRmcjIDcDpzLHY6dyxtOnNhLHNhX21rOjQxBGdwcmlkA3B1eDI4V29mUlNpNW5URUlrUGJZNEEEbl9yc2x0AzAEbl9zdWdnAzEwBG9yaWdpbgNzZWFyY2gueWFob28uY29tBHBvcwMxBHBxc3RyA3doZWF0aGVyBHBxc3RybAM4BHFzdHJsAzE2BHF1ZXJ5A3dlYXRoZXIlMjBmb3JlY2FzdAR0X3N0bXADMTY5NzQ2ODk2MwR1c2VfY2FzZQM-?p=weather+forecast&fr2=p%3As%2Cv%3Aw%2Cm%3Asa%2Csa_mk%3A41&fr=mcafee&type=E210US826G0&d=%7B%22subdn%22%3A%22weather%22%2C%22ykid%22%3A%222189663%22%7D&fd=%7B%22title%22%3A%22Cloudy%2C+74%C2%B0F%22%2C%22img_url%22%3A%22https%3A%2F%2Fs.yimg.com%2Fpv%2Fstatic%2Fimg%2Fweather%2F26.png%22%2C%22condition%22%3A%22Cloudy%22%2C%22degree%22%3A%2274%C2%B0F%22%2C%22loc%22%3A%22Matale%22%2C%22unit%22%3A%22F%22%2C%22condition_code%22%3A%2226%22%2C%22cur_temp%22%3A%2274%22%2C%22low_temp%22%3A%2265%22%2C%22high_temp%22%3A%2284%22%2C%22warning%22%3A%22%22%7D&mkr=41"
            val uri = Uri.parse(url)
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.data = uri
            startActivity(intent)

        }


    }
}