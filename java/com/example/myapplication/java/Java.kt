package com.example.myapplication.java

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.myapplication.R

class Java : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_java)

        val back:ImageView = findViewById(R.id.back)
        val introduction: Button = findViewById(R.id.intro_btn)
        val Basic:Button = findViewById(R.id.java_basic)
        val method:Button = findViewById(R.id.java_method)
        val oops:Button = findViewById(R.id.oops)
        val Android_App:Button = findViewById(R.id.android_app)

        back.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        introduction.setOnClickListener {
            intent = Intent(applicationContext, Intro_Java::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        Basic.setOnClickListener{
            intent = Intent(applicationContext, Java_Basic::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        method.setOnClickListener {
            intent = Intent(applicationContext, JavaMethod::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        oops.setOnClickListener {
            intent = Intent(applicationContext, JavaOOPs::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

    }
}