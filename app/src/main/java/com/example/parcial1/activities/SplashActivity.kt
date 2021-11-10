package com.example.parcial1.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.parcial1.R

class SplashActivity : AppCompatActivity() {
    private val tiempo:Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

            Handler().postDelayed({

                startActivity(Intent(this,MainActivity::class.java))
                finish()
            }, tiempo)

    }
}