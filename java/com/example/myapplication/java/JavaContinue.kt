package com.example.myapplication.java

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R

class JavaContinue : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_javacontinue)

        val back: ImageView = findViewById(R.id.back)
        back.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val next: Button = findViewById(R.id.next_btn)
        val previous: Button = findViewById(R.id.prev_btn)
        previous.setOnClickListener {
            intent = Intent(this,  JavaBreak::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        next.setOnClickListener {
            intent = Intent(this,  Java_Array::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val continue_code:TextView = findViewById(R.id.continue_code)
        continue_code.setOnClickListener {
            val textToCopy = continue_code.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text", textToCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this, "Code copied", Toast.LENGTH_SHORT).show()
        }

    }
}