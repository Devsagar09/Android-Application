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

class kotlin_function : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_function)

        val back = findViewById<ImageButton>(R.id.backKotlin_function)
        back.setOnClickListener {
            intent = Intent(applicationContext , kotlin_function_list::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val standard_lib_ex_kt = findViewById<TextView>(R.id.standard_lib_ex_kt)
        val user_define_fun_ex_kt = findViewById<TextView>(R.id.user_define_fun_ex_kt)

        standard_lib_ex_kt.setOnClickListener {

            val textToCopy = standard_lib_ex_kt.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text" , textToCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this , "Code copied !" , Toast.LENGTH_SHORT).show()
        }

        user_define_fun_ex_kt.setOnClickListener {

            val textToCopy = user_define_fun_ex_kt.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text" , textToCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this , "Code copied !" , Toast.LENGTH_SHORT).show()
        }
        val next = findViewById<Button>(R.id.nxt_fun_kt)
        next.setOnClickListener {
            intent = Intent(applicationContext , infix_fun_call::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
    }
}