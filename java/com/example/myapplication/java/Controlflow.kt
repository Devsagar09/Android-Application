package com.example.myapplication.java

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.myapplication.R

class Controlflow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_controlflow)

        val back:ImageView = findViewById(R.id.back7)
        back.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val ifelse:Button = findViewById(R.id.ifelse)
        ifelse.setOnClickListener {
                intent = Intent(this,  IFelsestat::class.java)
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val switchstate:Button = findViewById(R.id.switchstatement)
        switchstate.setOnClickListener {
            intent = Intent(this,Java_Switch::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val loops:Button = findViewById(R.id.loops)
        loops.setOnClickListener {
            intent = Intent(this,JavaLoop::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val breakstat:Button = findViewById(R.id.breakstat)
        breakstat.setOnClickListener {
            intent = Intent(this,JavaBreak::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val continuestat:Button = findViewById(R.id.continuestat)
        continuestat.setOnClickListener {
            intent = Intent(this,JavaContinue::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

    }
}