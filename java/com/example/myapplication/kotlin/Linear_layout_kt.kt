package com.example.myapplication.kotlin

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.myapplication.R

class linear_layout_kt : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_layout_kt)

        val backBtn = findViewById<ImageButton>(R.id.BackBtn_linear_kt)
        backBtn.setOnClickListener {
            intent = Intent(applicationContext , layout_kotlin::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val prvs = findViewById<Button>(R.id.prvs_linear_kt)
        prvs.setOnClickListener {
            intent = Intent(applicationContext , intro_layouts_kt::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val nxt = findViewById<Button>(R.id.nxt_linear_kt)
        nxt.setOnClickListener {
            intent = Intent(applicationContext , Relative_layout_kt::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
    }}