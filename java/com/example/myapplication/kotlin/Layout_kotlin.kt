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

class layout_kotlin : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_kotlin)

        val backBtn = findViewById<ImageButton>(R.id.BackBtn_Layout_kt)
        backBtn.setOnClickListener {
            intent = Intent(applicationContext , Kotlin::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val btn1 = findViewById<Button>(R.id.intro_layout)
        btn1.setOnClickListener {
            intent = Intent(applicationContext , intro_layouts_kt::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val btn2 = findViewById<Button>(R.id.kt_linear_layout)
        btn2.setOnClickListener {
            intent = Intent(applicationContext , linear_layout_kt::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val btn3 = findViewById<Button>(R.id.kt_Relative_layout)
        btn3.setOnClickListener {
            intent = Intent(applicationContext , Relative_layout_kt::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val btn4 = findViewById<Button>(R.id.kt_constraint_layout)
        btn4.setOnClickListener {
            intent = Intent(applicationContext , constraint_layout_kt::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
    }
}