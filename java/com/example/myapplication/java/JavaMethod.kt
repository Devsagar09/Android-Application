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

class JavaMethod : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_java_method)
        val back: ImageView = findViewById(R.id.back)
        back.setOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }

        val predefine:TextView = findViewById(R.id.predifined_code)
        val userdefine:TextView = findViewById(R.id.userdifined_code)

        predefine.setOnClickListener {
            val textToCopy = predefine.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text", textToCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this, "Code copied", Toast.LENGTH_SHORT).show()
        }

        userdefine.setOnClickListener {
            val textCopy = userdefine.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipdata = ClipData.newPlainText("text", textCopy)
            clipboardManager.setPrimaryClip(clipdata)
            Toast.makeText(this, "Code copied", Toast.LENGTH_SHORT).show()
        }

        val next: Button = findViewById(R.id.next_btn)
        val prev: Button = findViewById(R.id.prev_btn)

        prev.setOnClickListener {
            intent = Intent(this,  Java_Basic::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        next.setOnClickListener {
            intent = Intent(this,  JavaOOPs::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
    }
}