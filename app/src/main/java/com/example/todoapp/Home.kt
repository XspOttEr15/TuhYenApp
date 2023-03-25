package com.example.todoapp
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val imageButtonone = findViewById<ImageButton>(R.id.ImageButton01)
        imageButtonone.setOnClickListener {
            val intent2 = Intent(this, InTuhYen::class.java)
            startActivity(intent2)
        }

        val imageButtonskin = findViewById<ImageButton>(R.id.imageButton02)
        imageButtonskin.setOnClickListener{
            val intent3 = Intent (this, skin_popup::class.java)
            startActivity(intent3)
        }


    }

}



