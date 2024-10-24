package com.example.myapplication.java

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.myapplication.R

class JavaOOPs : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_java_oops)

        val back: ImageView = findViewById(R.id.back)
        back.setOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }
        val objects:Button = findViewById(R.id.classobjects)
        objects.setOnClickListener {
            intent = Intent(applicationContext, JavaObject::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
    }
}

