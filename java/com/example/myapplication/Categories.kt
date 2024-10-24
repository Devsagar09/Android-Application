package com.example.myapplication

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.example.myapplication.java.Java

class Categories : Fragment() {

    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? ,
        savedInstanceState : Bundle?
    ) : View {

        val view : View = inflater.inflate(R.layout.fragment_categories , container , false)

        view.findViewById<CardView>(R.id.card1).setOnClickListener {
            val intent = Intent(activity , Kotlin::class.java)
            startActivity(
                intent ,
                ActivityOptions.makeSceneTransitionAnimation(activity).toBundle()
            )
        }

        view.findViewById<CardView>(R.id.card2).setOnClickListener {
            val intent = Intent(activity , Kotlin::class.java)
            startActivity(
                intent ,
                ActivityOptions.makeSceneTransitionAnimation(activity).toBundle()
            )
        }

        view.findViewById<CardView>(R.id.card3).setOnClickListener {
            val intent = Intent(activity , Kotlin::class.java)
            startActivity(
                intent ,
                ActivityOptions.makeSceneTransitionAnimation(activity).toBundle()
            )
        }

        view.findViewById<CardView>(R.id.card4).setOnClickListener {
            val intent = Intent(activity , Kotlin::class.java)
            startActivity(
                intent ,
                ActivityOptions.makeSceneTransitionAnimation(activity).toBundle()
            )
        }

        return view
    }
}