package com.example.myapplication.kotlin

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.myapplication.Kotlin
import com.example.myapplication.R

class first_app_kt : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app_kt)

        val backButton = findViewById<ImageButton>(R.id.backKotlin_first_app)
        backButton.setOnClickListener {
            intent = Intent(applicationContext , Kotlin::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val done = findViewById<Button>(R.id.done_first_app_kt)
        done.setOnClickListener {
            intent = Intent(applicationContext , Kotlin::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
    }
}