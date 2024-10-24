package com.example.myapplication.java

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.myapplication.R

class Intro_Java : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_java)

        val back: ImageView = findViewById(R.id.back)

        back.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

    }
}