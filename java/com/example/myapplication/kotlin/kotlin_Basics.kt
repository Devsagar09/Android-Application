package com.example.myapplication.kotlin

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.myapplication.Kotlin
import com.example.myapplication.R

class kotlin_Basics : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_basics)

        val back = findViewById<ImageButton>(R.id.backKotlinBasic)

        back.setOnClickListener {
            intent = Intent(applicationContext , Kotlin::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val btn1 = findViewById<Button>(R.id.kt_operators)

        btn1.setOnClickListener {
            intent = Intent(applicationContext , Kotlin_Operators::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val btn2 = findViewById<Button>(R.id.kt_data_types)

        btn2.setOnClickListener {
            intent = Intent(applicationContext , kotlin_data_types::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val btn3 = findViewById<Button>(R.id.kt_variables)

        btn3.setOnClickListener {
            intent = Intent(applicationContext , kotlin_variables::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val btn4 = findViewById<Button>(R.id.kt_conditional)

        btn4.setOnClickListener {
            intent = Intent(applicationContext , kotlin_conditional::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val btn5 = findViewById<Button>(R.id.kt_lists_arrays)

        btn5.setOnClickListener {
            intent = Intent(applicationContext , kotlin_list_array::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val btn6 = findViewById<Button>(R.id.kt_null_safety)

        btn6.setOnClickListener {
            intent = Intent(applicationContext , kotlin_null_safety::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val btn7 = findViewById<Button>(R.id.kt_basic_summary)

        btn7.setOnClickListener {
            intent = Intent(applicationContext , kotlin_basics_summary::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
    }
}