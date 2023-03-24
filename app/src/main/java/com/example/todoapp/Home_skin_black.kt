package com.example.todoapp
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Home_skin_black : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_skinblack)


        val imageButtonone = findViewById<ImageButton>(R.id.ImageButton01)
        imageButtonone.setOnClickListener {
            val intent2 = Intent(this, InTuhYen_skin_black::class.java)
            startActivity(intent2)
        }

        val imageButtonskin = findViewById<ImageButton>(R.id.imageButton02)
        imageButtonskin.setOnClickListener{
            val intent4 = Intent (this, skin_popup::class.java)
            startActivity(intent4)
        }
    }

}



