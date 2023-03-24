package com.example.todoapp
import android.content.Intent
import android.media.AsyncPlayer
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_login.*


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val mediaPlayer = MediaPlayer.create(this, R.raw.ricky)
        mediaPlayer.isLooping = true

        val button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener{
            val intent1 = Intent (this, Home::class.java)
            startActivity(intent1)
        }

        playButton.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
            } else {
                mediaPlayer.start()

            }
        }
    }

}