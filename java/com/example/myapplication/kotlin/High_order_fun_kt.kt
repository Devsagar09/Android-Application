package com.example.myapplication.kotlin

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.ImageButton
import com.example.myapplication.R

class High_order_fun_kt : AppCompatActivity() {
    @SuppressLint("MissingInflatedId" , "SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_high_order_fun_kt)

        val back = findViewById<ImageButton>(R.id.backKotlin_high_order_kt)
        back.setOnClickListener {
            intent = Intent(applicationContext , kotlin_function_list::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val webView1 = findViewById<WebView>(R.id.lambda_1_playground)
        webView1.loadUrl("https://pl.kotl.in/fXp5GB35I?theme=darcula&from=1&to=9")
        webView1.settings.javaScriptEnabled = true
        webView1.webViewClient = WebViewClient()

        val webView2 = findViewById<WebView>(R.id.lambda_2_playground)
        webView2.loadUrl("https://pl.kotl.in/KPX2eyA44?from=1&to=12&theme=darcula")
        webView2.settings.javaScriptEnabled = true
        webView2.webViewClient = WebViewClient()

        val previous = findViewById<Button>(R.id.prvs_H_O_kt)
        previous.setOnClickListener {
            intent = Intent(applicationContext , kotlin_lambdas::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val next = findViewById<Button>(R.id.nxt_H_O_kt)
        next.setOnClickListener {
            intent = Intent(applicationContext , summary_function_kotlin::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
    }
}