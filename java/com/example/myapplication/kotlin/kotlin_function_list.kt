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

class kotlin_function_list : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_function_list)

        val back = findViewById<ImageButton>(R.id.backKotlin_function_list)
        back.setOnClickListener {
            intent = Intent(applicationContext , Kotlin::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val btn1 = findViewById<Button>(R.id.kt_Function_in_kotlin)
        btn1.setOnClickListener {
            intent = Intent(applicationContext , kotlin_function::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val btn2 = findViewById<Button>(R.id.kt_infix_fun)
        btn2.setOnClickListener {
            intent = Intent(applicationContext , infix_fun_call::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val btn3 = findViewById<Button>(R.id.kt_fun_parameters)
        btn3.setOnClickListener {
            intent = Intent(applicationContext , fun_parameters_kt::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val btn4 = findViewById<Button>(R.id.kt_recursion_fun)
        btn4.setOnClickListener {
            intent = Intent(applicationContext , kotlin_recursion::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val btn5 = findViewById<Button>(R.id.kt_lambdas_exp)
        btn5.setOnClickListener {
            intent = Intent(applicationContext , kotlin_lambdas::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val btn6 = findViewById<Button>(R.id.kt_higher_order)
        btn6.setOnClickListener {
            intent = Intent(applicationContext , High_order_fun_kt::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val btn7 = findViewById<Button>(R.id.kt_fun_summary)
        btn7.setOnClickListener {
            intent = Intent(applicationContext , summary_function_kotlin::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
    }
}