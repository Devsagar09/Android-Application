package com.example.myapplication.java

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.myapplication.R

class BasicSummary : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_summary)
        val back: ImageView = findViewById(R.id.back)
        back.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val Done: Button = findViewById(R.id.next_btn)
        val previous: Button = findViewById(R.id.prev_btn)
        previous.setOnClickListener {
            intent = Intent(this,  Java_Array::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        Done.setOnClickListener {
            intent = Intent(this,  Java_Basic::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

    }
}