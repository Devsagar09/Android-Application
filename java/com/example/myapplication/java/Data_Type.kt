package com.example.myapplication.java

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedDispatcher
import com.example.myapplication.R

class Data_Type : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_type)

        val back:ImageView = findViewById(R.id.back3)
        val prev:Button = findViewById(R.id.prev_btn)
        val next:Button = findViewById(R.id.next_btn)
        val booleantype:TextView = findViewById(R.id.Booleantype)
        val Integer:TextView = findViewById(R.id.Integer_code)
        val Long:TextView = findViewById(R.id.Long)
        val Float:TextView = findViewById(R.id.Float)
        val Double:TextView = findViewById(R.id.Double)
        val str_btn:Button = findViewById(R.id.String_btn)
        val array_btn:Button = findViewById(R.id.Array_btn)

        prev.setOnClickListener {
            intent = Intent(this,  Variable::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        next.setOnClickListener {
            intent = Intent(this,  Java_operator::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        booleantype.setOnClickListener {
            val textToCopy = booleantype.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text", textToCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this, "Code copied", Toast.LENGTH_SHORT).show()
        }

        Integer.setOnClickListener {
            val textToCopy = Integer.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text", textToCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this, "Code copied", Toast.LENGTH_SHORT).show()
        }

        Long.setOnClickListener {
            val textToCopy = Long.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text", textToCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this, "Code copied", Toast.LENGTH_SHORT).show()
        }

        Float.setOnClickListener {
            val textToCopy = Float.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text", textToCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this, "Code copied", Toast.LENGTH_SHORT).show()
        }

        Double.setOnClickListener {
            val textToCopy = Double.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text", textToCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this, "Code copied", Toast.LENGTH_SHORT).show()
        }

        str_btn.setOnClickListener {
            intent = Intent(applicationContext, Java_String::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        array_btn.setOnClickListener {
            intent = Intent(applicationContext, Java_Array::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        back.setOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }
    }
}