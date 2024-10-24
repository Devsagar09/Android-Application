package com.example.myapplication.kotlin

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.ImageView
import com.example.myapplication.R

class classes_objects_kotlin : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_classes_objects_kotlin)

        val btnback = findViewById<ImageView>(R.id.backKotlin_class_objects)
        btnback.setOnClickListener {
            intent = Intent(applicationContext , class_and_object_list::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val webView1 = findViewById<WebView>(R.id.class_obj_example_playground)
        webView1.loadUrl("https://pl.kotl.in/XSkGo61ml?theme=darcula&from=1&to=34")
        webView1.settings.javaScriptEnabled = true
        webView1.webViewClient = WebViewClient()

        val next = findViewById<Button>(R.id.nxt_class_obj_kt)
        next.setOnClickListener {
            intent = Intent(applicationContext , kotlin_constructor::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

    }
}