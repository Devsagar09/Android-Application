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

class object_kotlin : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object_kotlin)

        val btnback = findViewById<ImageView>(R.id.backKotlin_object)
        btnback.setOnClickListener {
            intent = Intent(applicationContext , class_and_object_list::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val webView1 = findViewById<WebView>(R.id.ex_obj_declaration_playground)
        webView1.loadUrl("https://pl.kotl.in/MSvxYVGsT?from=1&to=18&theme=darcula")
        webView1.settings.javaScriptEnabled = true
        webView1.webViewClient = WebViewClient()

        val webView2 = findViewById<WebView>(R.id.ex_obj_expression_playground)
        webView2.loadUrl("https://pl.kotl.in/JvR8Ma2q_?from=1&to=17&theme=darcula")
        webView2.settings.javaScriptEnabled = true
        webView2.webViewClient = WebViewClient()

        val previous = findViewById<Button>(R.id.prvs_object_kt)
        previous.setOnClickListener {
            intent = Intent(applicationContext , abstract_class_kt::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
    }
}