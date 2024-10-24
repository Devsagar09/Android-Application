package com.example.myapplication.java

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

class Java_Switch : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_java_switch)

        val back: ImageView = findViewById(R.id.back)
        back.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val switch_code:TextView = findViewById(R.id.ifelse_code1)
        switch_code.setOnClickListener {
            val textToCopy = switch_code.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text", textToCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this, "Code copied", Toast.LENGTH_SHORT).show()
        }

        val next:Button = findViewById(R.id.next_btn)
        val previous:Button = findViewById(R.id.prev_btn)
        previous.setOnClickListener {
            intent = Intent(this,  IFelsestat::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        next.setOnClickListener {
            intent = Intent(this,  JavaLoop::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
    }
}