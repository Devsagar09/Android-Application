package com.example.myapplication.java

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.myapplication.R

class Java_Basic : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_java_basic)

        val back: ImageView = findViewById(R.id.back)
        val variable: Button = findViewById(R.id.variable_btn)
        val datatype:Button = findViewById(R.id.datatype)
        val array:Button = findViewById(R.id.array)
        val operators:Button = findViewById(R.id.operator)
        val control:Button = findViewById(R.id.control_flow)
        val summary:Button = findViewById(R.id.summary)

        back.setOnClickListener {
            intent = Intent(this,  Java::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        variable.setOnClickListener{
            intent = Intent(this,  Variable::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        datatype.setOnClickListener{
            intent = Intent(this,  Data_Type::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        array.setOnClickListener {
            intent = Intent(this,  Java_Array::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        operators.setOnClickListener {
            intent = Intent(this,  Java_operator::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        control.setOnClickListener {
            intent = Intent(this,  Controlflow::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        summary.setOnClickListener {
            intent = Intent(this,  BasicSummary::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
    }
}

