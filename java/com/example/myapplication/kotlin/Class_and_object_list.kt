package com.example.myapplication.kotlin

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.myapplication.*

class class_and_object_list : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class_and_object_list)

        val btnback = findViewById<ImageView>(R.id.backKotlin_classes_objects)
        btnback.setOnClickListener {
            intent = Intent(applicationContext , Kotlin::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val btn1 = findViewById<Button>(R.id.kt_class_object_OC)
        btn1.setOnClickListener {
            intent = Intent(applicationContext , classes_objects_kotlin::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val btn2 = findViewById<Button>(R.id.kt_constructors)
        btn2.setOnClickListener {
            intent = Intent(applicationContext , kotlin_constructor::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val btn3 = findViewById<Button>(R.id.kt_get_set)
        btn3.setOnClickListener {
            intent = Intent(applicationContext , getter_setter_kt::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val btn4 = findViewById<Button>(R.id.kt_inheritance)
        btn4.setOnClickListener {
            intent = Intent(applicationContext , inheritance_kt::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val btn5 = findViewById<Button>(R.id.kt_Abs_class)
        btn5.setOnClickListener {
            intent = Intent(applicationContext , abstract_class_kt::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val btn6 = findViewById<Button>(R.id.kt_obj)
        btn6.setOnClickListener {
            intent = Intent(applicationContext , object_kotlin::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val btn7 = findViewById<Button>(R.id.kt_Class_Obj_summary)
        btn7.setOnClickListener {
            intent = Intent(applicationContext , summary_class_obj_kt::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
    }
}