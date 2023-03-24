package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.todoapp.R

class skin_popup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skin_popup)

        val imageskinblack = findViewById<ImageButton>(R.id.imageButton32)
        imageskinblack.setOnClickListener {
            val intent2 = Intent(this, Home_skin_black::class.java)
            startActivity(intent2)
        }

        val imageskinblue = findViewById<ImageButton>(R.id.imageButton31)
        imageskinblue.setOnClickListener {
            val intent3 = Intent(this, Home_skin_blue::class.java)
            startActivity(intent3)
        }

        val imagedefault = findViewById<ImageButton>(R.id.imageButton30)
        imagedefault.setOnClickListener {
            val intent4 = Intent(this, Home::class.java)
            startActivity(intent4)
        }


    }
}