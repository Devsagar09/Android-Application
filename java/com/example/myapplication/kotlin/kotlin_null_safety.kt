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

class kotlin_null_safety : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_null_safety)

        val back = findViewById<ImageButton>(R.id.backKotlinBasic_null_safety)
        back.setOnClickListener{
            intent = Intent(applicationContext , kotlin_Basics::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        var nullable_ex_kt : TextView = findViewById(R.id.nullable_ex_kt)
        var smart_case_ex_kt : TextView = findViewById(R.id.smart_case_ex_kt)
        var Non_nullable_ex_kt : TextView = findViewById(R.id.Non_nullable_ex_kt)

        nullable_ex_kt.setOnClickListener {

            val textToCopy = nullable_ex_kt.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text" , textToCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this , "Code copied !" , Toast.LENGTH_SHORT).show()
        }

        Non_nullable_ex_kt.setOnClickListener {

            val textToCopy = Non_nullable_ex_kt.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text" , textToCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this , "Code copied !" , Toast.LENGTH_SHORT).show()
        }

        smart_case_ex_kt.setOnClickListener {

            val textToCopy = smart_case_ex_kt.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text" , textToCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this , "Code copied !" , Toast.LENGTH_SHORT).show()
        }

        val next = findViewById<Button>(R.id.nxt_null_safety_kt)
        next.setOnClickListener {
            intent = Intent(applicationContext , kotlin_basics_summary::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val previous = findViewById<Button>(R.id.prvs_null_safety_kt)
        previous.setOnClickListener {
            intent = Intent(applicationContext , kotlin_list_array::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

    }
}