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

class kotlin_lambdas : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_lambdas)

        val back = findViewById<ImageButton>(R.id.backKotlin_lambdas)
        back.setOnClickListener {
            intent = Intent(applicationContext , kotlin_function_list::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val kotlin_lambdas_ex_kt = findViewById<TextView>(R.id.kotlin_lambdas_ex_kt)
        kotlin_lambdas_ex_kt.setOnClickListener {
            val textToCopy = kotlin_lambdas_ex_kt.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text" , textToCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this , "Code copied !" , Toast.LENGTH_SHORT).show()
        }

        val previous = findViewById<Button>(R.id.prvs_lambda_kt)
        previous.setOnClickListener {
            intent = Intent(applicationContext , kotlin_recursion::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val next = findViewById<Button>(R.id.nxt_lambda_kt)
        next.setOnClickListener {
            intent = Intent(applicationContext , High_order_fun_kt::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
    }
}