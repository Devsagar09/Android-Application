package com.example.myapplication.java

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityJavaObjectBinding

class JavaObject : AppCompatActivity() {
    private lateinit var binding: ActivityJavaObjectBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJavaObjectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back.setOnClickListener(){
            onBackPressedDispatcher.onBackPressed()
        }
    }
}