package com.example.myapplication.kotlin

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R

class Kotlin_Operators : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_operators)

        val back = findViewById<ImageButton>(R.id.backKotlinBasic)
        back.setOnClickListener{
            intent = Intent(applicationContext , kotlin_Basics::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val next = findViewById<Button>(R.id.nxt_oprtr_kt)
        next.setOnClickListener{
            intent = Intent(applicationContext , kotlin_data_types::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        var mathematical_ex : TextView = findViewById(R.id.mathematical_ex)
        var inc_dec_ex : TextView = findViewById(R.id.inc_dec_ex)
        var comparison_ex : TextView = findViewById(R.id.comparison_ex)
        var assignment_ex : TextView = findViewById(R.id.assignment_ex)

        mathematical_ex.setOnClickListener {

            val textToCopy = mathematical_ex.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text" , textToCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this , "Code copied !" , Toast.LENGTH_SHORT).show()
        }

        inc_dec_ex.setOnClickListener {

            val textToCopy = inc_dec_ex.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text" , textToCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this , "Code copied !" , Toast.LENGTH_SHORT).show()
        }

        comparison_ex.setOnClickListener {

            val textToCopy = comparison_ex.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text" , textToCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this , "Code copied !" , Toast.LENGTH_SHORT).show()
        }

        assignment_ex.setOnClickListener {

            val textToCopy = assignment_ex.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text" , textToCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this , "Code copied !" , Toast.LENGTH_SHORT).show()
        }
    }
}