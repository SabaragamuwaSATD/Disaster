package com.example.disaster

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.disaster.database.Disaster
import com.example.disaster.database.D_Database
import com.example.disaster.database.D_Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddDisasters : AppCompatActivity() {
    lateinit var adapter: DisasterAdapter
    lateinit var viewModel: MainActivityData
    private var selectedPhotoPath: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_disaster)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val repository = D_Repository(D_Database.getInstance(this))
        val viewModel = ViewModelProvider(this)[MainActivityData::class.java]

// Back button to return to the main activity
        val back: Button = findViewById(R.id.button2)
        back.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }



// Observe data changes in ViewModel and update the RecyclerView
        viewModel.data.observe(this) {
            adapter = DisasterAdapter(it, repository, viewModel)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this)

        }

// Fetch data from the repository in a background thread and update
        CoroutineScope(Dispatchers.IO).launch {
            val data = repository.getAllDisaster()
            runOnUiThread {
                viewModel.setData(data)
            }
        }

// Add button to display an alert dialog for adding a new disaster
        val addItem: Button = findViewById(R.id.button)
        addItem.setOnClickListener {
            displayAlert(repository)

        }

    }

    private fun displayAlert(repository: D_Repository) {
        val builder = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.add_disaster_popup, null)
        val editTextTitle = dialogView.findViewById<EditText>(R.id.editTextTitle)
        val editTextDistrict = dialogView.findViewById<EditText>(R.id.editTextDistrict)
        val editTextDiscription = dialogView.findViewById<EditText>(R.id.editTextDis)
        val btnUploadPhoto = dialogView.findViewById<ImageView>(R.id.selectphoto)

        builder.setView(dialogView).setTitle(getText(R.string.Alert))
            .setPositiveButton("Save") { dialog, which ->
                val title = editTextTitle.text.toString()
                val place = editTextDistrict.text.toString()
                val dis = editTextDiscription.text.toString()

                if (title.isNotBlank() && place.isNotBlank() && dis.isNotBlank()) {
                    val disaster = Disaster(
                        title, place, dis, selectedPhotoPath!!
                    )
                    CoroutineScope(Dispatchers.IO).launch {
                        repository.insert(disaster)
                    }
                }
            }.setNegativeButton("Cancel") { dialog, which ->
                dialog.cancel()
            }.show()

// Button to open the gallery for selecting a photo
        btnUploadPhoto.setOnClickListener {
            val galleryIntent =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(galleryIntent, 1)
        }

// Display the selected photo in the ImageView if available
        if (selectedPhotoPath != null) {
            val selectPhotoImageView = dialogView.findViewById<ImageView>(R.id.selectphoto)
            selectPhotoImageView.setImageURI(Uri.parse(selectedPhotoPath))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null) {
            val selectedImageUri: Uri = data.data!!
            selectedPhotoPath = getPathFromUri(selectedImageUri)
        }
    }

    private fun getPathFromUri(uri: Uri): String {
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = contentResolver.query(uri, projection, null, null, null)
        val columnIndex = cursor!!.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        cursor.moveToFirst()
        val path = cursor.getString(columnIndex)
        cursor.close()
        return path
    }


}