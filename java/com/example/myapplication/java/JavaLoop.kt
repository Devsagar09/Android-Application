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

class JavaLoop : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_java_loop)

        val back: ImageView = findViewById(R.id.back)
        back.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val next: Button = findViewById(R.id.next_btn)
        val previous: Button = findViewById(R.id.prev_btn)
        previous.setOnClickListener {
            intent = Intent(this,  Java_Switch::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        next.setOnClickListener {
            intent = Intent(this,  JavaBreak::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val forloop:TextView = findViewById(R.id.forloop)
        val whileloop:TextView = findViewById(R.id.whileloop)
        val dowhile:TextView = findViewById(R.id.dowhileloop)

        forloop.setOnClickListener {
            val textToCopy = forloop.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text", textToCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this, "Code copied", Toast.LENGTH_SHORT).show()
        }

        whileloop.setOnClickListener {
            val textToCopy = whileloop.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text", textToCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this, "Code copied", Toast.LENGTH_SHORT).show()
        }

        dowhile.setOnClickListener {
            val textToCopy = dowhile.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text", textToCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this, "Code copied", Toast.LENGTH_SHORT).show()
        }
    }
}