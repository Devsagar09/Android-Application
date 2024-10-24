package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.media.Image
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.provider.SyncStateContract
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

@Suppress("DEPRECATION")
class SplashScreenActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    private lateinit var firebaseAuth: FirebaseAuth
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
        )
        setContentView(R.layout.activity_splash_screen)
        firebaseAuth = FirebaseAuth.getInstance()


//        val background: ImageView = findViewById(R.id.img1)
        val appname:TextView = findViewById(R.id.spalshscreenappname)
        val appname2:TextView = findViewById(R.id.spalshscreenappname2)
        val logo = findViewById<ImageView>(R.id.img1)


        val animation2 = AnimationUtils.loadAnimation(this,R.anim.slide_up)
//        background.startAnimation(sideAnimation)
        logo.startAnimation(animation2)
        appname.startAnimation(animation2)
        appname2.startAnimation(animation2)
        Handler().postDelayed({
              if(firebaseAuth.currentUser != null){
                  startActivity(Intent(this,bottomNavigationHomescreen::class.java))
              }else{
                  startActivity(Intent(this,MainActivity::class.java))
              }
            finish()
        },1200)


    }
}