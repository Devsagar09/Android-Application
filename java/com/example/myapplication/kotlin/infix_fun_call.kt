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

class infix_fun_call : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infix_fun_call)

        val previous = findViewById<Button>(R.id.prvs_infix_kt)
        previous.setOnClickListener {
            intent = Intent(applicationContext , kotlin_function::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val next = findViewById<Button>(R.id.nxt_infix_kt)
        next.setOnClickListener {
            intent = Intent(applicationContext , fun_parameters_kt::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val back = findViewById<ImageButton>(R.id.backKotlin_infixfun)
        back.setOnClickListener {
            intent = Intent(applicationContext , kotlin_function_list::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val infix_fun_ex_kt = findViewById<TextView>(R.id.infix_fun_ex_kt)
        infix_fun_ex_kt.setOnClickListener {
            val textToCopy = infix_fun_ex_kt.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text" , textToCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this , "Code copied !" , Toast.LENGTH_SHORT).show()
        }
    }
}