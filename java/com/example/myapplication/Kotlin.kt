package com.example.myapplication


import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityKotlinBinding
import com.example.myapplication.kotlin.kotlin_introduction

class Kotlin : AppCompatActivity() {
    lateinit var binding : ActivityKotlinBinding
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKotlinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.BacktoAllfromKotlin.setOnClickListener() {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.intro.setOnClickListener {
            intent = Intent(applicationContext , kotlin_introduction::class.java)
            startActivity(intent , ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
    }
}
