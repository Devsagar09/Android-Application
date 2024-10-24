package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.ActivityBottomNavigationHomescreenBinding

class bottomNavigationHomescreen : AppCompatActivity() {
    private lateinit var binding: ActivityBottomNavigationHomescreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavigationHomescreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(Home())

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.btNvHome -> replaceFragment(Home())
                R.id.btNvAll -> replaceFragment(Categories())
                R.id.btNvProfile -> replaceFragment(Profile())
                else -> {
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.btNav_frameLayout,fragment)
        fragmentTransaction.commit()
    }
}