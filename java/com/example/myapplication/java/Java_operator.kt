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
import org.w3c.dom.Text

class Java_operator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_java_operator)

        val back: ImageView = findViewById(R.id.back5)
        back.setOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }

        val arithmetic:TextView = findViewById(R.id.arithmetic)
        val assignment:TextView = findViewById(R.id.assignment)
        val relational:TextView = findViewById(R.id.relational)
        val logical:TextView = findViewById(R.id.logical)
        val unary:TextView = findViewById(R.id.unary)
        val next:Button = findViewById(R.id.next_btn)
        val prev:Button = findViewById(R.id.prev_btn)

        prev.setOnClickListener {
            intent = Intent(this,  Data_Type::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        next.setOnClickListener {
            intent = Intent(this,  IFelsestat::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        arithmetic.setOnClickListener {
            val textToCopy = arithmetic.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text", textToCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this, "Code copied", Toast.LENGTH_SHORT).show()
        }

        assignment.setOnClickListener {
            val textToCopy = assignment.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text", textToCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this, "Code copied", Toast.LENGTH_SHORT).show()
        }

        relational.setOnClickListener {
            val textToCopy = relational.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text", textToCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this, "Code copied", Toast.LENGTH_SHORT).show()
        }

        logical.setOnClickListener {
            val textToCopy = logical.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text", textToCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this, "Code copied", Toast.LENGTH_SHORT).show()
        }

        unary.setOnClickListener {
            val textToCopy = unary.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text", textToCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this, "Code copied", Toast.LENGTH_SHORT).show()
        }

    }
}