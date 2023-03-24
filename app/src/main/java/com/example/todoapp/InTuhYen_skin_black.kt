package com.example.todoapp


import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Matrix
import android.media.ExifInterface
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home_skinblack.*


@Suppress("DEPRECATION")
class InTuhYen_skin_black : AppCompatActivity() {

    private lateinit var imageButton: ImageButton
    private var initialX = 0
    private var initialY = 0
    private var dX = 0
    private var dY = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intuhyen_skinblack)

        imageButton = findViewById(R.id.image_button)

        val imageButton: ImageButton = findViewById(R.id.image_button)
        val imageButton2: ImageButton = findViewById(R.id.image_button2)

        val imageButtontwo = findViewById<ImageButton>(R.id.imageButton26)
        imageButtontwo.setOnClickListener {
            val intent2 = Intent(this, ToDoList::class.java)
            startActivity(intent2)
        }
        imageButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
        }

        imageButton2.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, PICK_IMAGE_REQUEST_2)
        }

    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            val uri: Uri = data.data!!
            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri)
            val scaledBitmap = Bitmap.createScaledBitmap(bitmap, 600, 400, false)

            // Check the image orientation and rotate if necessary
            val exif = ExifInterface(contentResolver.openInputStream(uri)!!)
            val orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_UNDEFINED)
            val rotatedBitmap = when (orientation) {
                ExifInterface.ORIENTATION_ROTATE_90 -> scaledBitmap.rotate(90f)
                ExifInterface.ORIENTATION_ROTATE_180 -> scaledBitmap.rotate(180f)
                ExifInterface.ORIENTATION_ROTATE_270 -> scaledBitmap.rotate(270f)
                else -> scaledBitmap
            }

            imageButton.setImageBitmap(rotatedBitmap)
        } else if (requestCode == PICK_IMAGE_REQUEST_2 && resultCode == RESULT_OK && data != null) {
            val uri: Uri = data.data!!
            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri)
            val scaledBitmap = Bitmap.createScaledBitmap(bitmap, 600, 400, false)

            // Check the image orientation and rotate if necessary
            val exif = ExifInterface(contentResolver.openInputStream(uri)!!)
            val orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_UNDEFINED)
            val rotatedBitmap = when (orientation) {
                ExifInterface.ORIENTATION_ROTATE_90 -> scaledBitmap.rotate(90f)
                ExifInterface.ORIENTATION_ROTATE_180 -> scaledBitmap.rotate(180f)
                ExifInterface.ORIENTATION_ROTATE_270 -> scaledBitmap.rotate(270f)
                else -> scaledBitmap
            }

            val imageButton2: ImageButton = findViewById(R.id.image_button2)
            imageButton2.setImageBitmap(rotatedBitmap)
        }
    }

    // Extension function to rotate a bitmap
    fun Bitmap.rotate(degrees: Float): Bitmap {
        val matrix = Matrix().apply { postRotate(degrees) }
        return Bitmap.createBitmap(this, 0, 0, width, height, matrix, true)
    }

    companion object {
        private const val PICK_IMAGE_REQUEST = 1
        private const val PICK_IMAGE_REQUEST_2 = 2
    }

    override fun onPause() {
        super.onPause()

        val preferences = getPreferences(Context.MODE_PRIVATE)
        preferences.edit().putString("IMAGE_URI", imageButton.tag?.toString()).apply()

    }

    override fun onResume() {
        super.onResume()

        val preferences = getPreferences(Context.MODE_PRIVATE)
        val uriString = preferences.getString("IMAGE_URI", null)

        if (uriString != null) {
            val uri = Uri.parse(uriString)
            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri)
            imageButton.setImageBitmap(bitmap)
            imageButton.tag = uriString
        }
    }




}