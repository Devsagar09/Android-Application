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

class summary_class_obj_kt : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary_class_obj_kt)

        val back = findViewById<ImageButton>(R.id.backKotlin_summary_class_obj)
        back.setOnClickListener{
            intent = Intent(applicationContext , class_and_object_list::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val next = findViewById<Button>(R.id.done_summary_kt)
        next.setOnClickListener {
            intent = Intent(applicationContext , Kotlin::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val previous = findViewById<Button>(R.id.prvs_summary_kt)
        previous.setOnClickListener {
            intent = Intent(applicationContext , object_kotlin::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
    }
}