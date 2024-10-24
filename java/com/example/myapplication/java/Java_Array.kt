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

class Java_Array : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_java_array)
        val single1:TextView = findViewById(R.id.single1)
        val single2:TextView = findViewById(R.id.single2)
        val multi:TextView = findViewById(R.id.multi_code   )

        single1.setOnClickListener {
            val textToCopy = single1.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text", textToCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this, "Code copied", Toast.LENGTH_SHORT).show()
        }

        single2.setOnClickListener {
            val textToCopy = single2.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text", textToCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this, "Code copied", Toast.LENGTH_SHORT).show()
        }

        multi.setOnClickListener {
            val textToCopy = multi.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text", textToCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this, "Code copied", Toast.LENGTH_SHORT).show()
        }

        val back: ImageView = findViewById(R.id.back5)
        back.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val next: Button = findViewById(R.id.next_btn)
        val previous: Button = findViewById(R.id.prev_btn)
        previous.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        next.setOnClickListener {
            intent = Intent(this,  BasicSummary::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
    }
}
