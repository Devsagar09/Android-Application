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

class abstract_class_kt : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abstract_class_kt)

        val btnback = findViewById<ImageView>(R.id.backKotlin_abstract)
        btnback.setOnClickListener {
            intent = Intent(applicationContext , class_and_object_list::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val webView1 = findViewById<WebView>(R.id.abs_class_ex_playground)
        webView1.loadUrl("https://pl.kotl.in/kQa6uMJNn?theme=darcula&from=1&to=25")
        webView1.settings.javaScriptEnabled = true
        webView1.webViewClient = WebViewClient()

        val previous = findViewById<Button>(R.id.prvs_abstract_kt)
        previous.setOnClickListener {
            intent = Intent(applicationContext , inheritance_kt::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val next = findViewById<Button>(R.id.nxt_abstract_kt)
        next.setOnClickListener {
            intent = Intent(applicationContext , object_kotlin::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
    }
}