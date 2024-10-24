package com.example.myapplication

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView

class Home : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        view.findViewById<CardView>(R.id.android_card).setOnClickListener {
            val intent = Intent(activity, Android::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(activity).toBundle())
        }

        view.findViewById<CardView>(R.id.kotlin_card).setOnClickListener {
            val intent = Intent(activity, Kotlin::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(activity).toBundle())
        }

        view.findViewById<CardView>(R.id.flutter_card).setOnClickListener {
            val intent = Intent(activity, Kotlin::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(activity).toBundle())
        }

        view.findViewById<CardView>(R.id.xcode_card).setOnClickListener(){
            val intent = Intent(activity,X_Code::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(activity).toBundle())
        }

        return view
    }
}