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

class kotlin_constructor : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_constructor)

        val btnback = findViewById<ImageView>(R.id.backKotlin_constructor)
        btnback.setOnClickListener {
            intent = Intent(applicationContext , class_and_object_list::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val webView1 = findViewById<WebView>(R.id.primary_constructor_example_playground)
        webView1.loadUrl("https://pl.kotl.in/DTMnBDY_o?theme=darcula&from=1&to=11")
        webView1.settings.javaScriptEnabled = true
        webView1.webViewClient = WebViewClient()

        val webView2 = findViewById<WebView>(R.id.primary_constructor_and_initializer_blocks_ex_playground)
        webView2.loadUrl("https://pl.kotl.in/IBN3JF84K?theme=darcula&from=1&to=17")
        webView2.settings.javaScriptEnabled = true
        webView2.webViewClient = WebViewClient()

        val webView3 = findViewById<WebView>(R.id.default_value_in_primary_constructor)
        webView3.loadUrl("https://pl.kotl.in/i3x-H3QDT?from=1&to=22&theme=darcula")
        webView3.settings.javaScriptEnabled = true
        webView3.webViewClient = WebViewClient()

        val webView4 = findViewById<WebView>(R.id.secondary_constructor_ex_playground)
        webView4.loadUrl("https://pl.kotl.in/bAtr11epj?theme=darcula&from=1&to=25")
        webView4.settings.javaScriptEnabled = true
        webView4.webViewClient = WebViewClient()


        val previous = findViewById<Button>(R.id.prvs_constructor_kt)
        previous.setOnClickListener {
            intent = Intent(applicationContext , classes_objects_kotlin::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val next = findViewById<Button>(R.id.nxt_constructor_kt)
        next.setOnClickListener {
            intent = Intent(applicationContext , getter_setter_kt::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

    }
}