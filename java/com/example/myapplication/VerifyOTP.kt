package com.example.myapplication

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.myapplication.databinding.ActivityVerifyOtpBinding
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import java.util.concurrent.TimeUnit

@Suppress("DEPRECATION")
class VerifyOTP : AppCompatActivity() {

    private lateinit var binding: ActivityVerifyOtpBinding

    private lateinit var auth: FirebaseAuth
    private lateinit var verifyBtn : Button
    private lateinit var inputOTP1 : EditText
    private lateinit var inputOTP2 : EditText
    private lateinit var inputOTP3 : EditText
    private lateinit var inputOTP4 : EditText
    private lateinit var inputOTP5 : EditText
    private lateinit var inputOTP6 : EditText
    private lateinit var progress : ProgressBar

    private lateinit var OTP : String

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerifyOtpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        OTP = intent.getStringExtra("OTP").toString()

        binding.backbtn2.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val i = intent
        val str = i.getStringExtra("Mobile")
        binding.setnumber.text = "Enter OTP sent to\n $str"

        init()
        addTextChangeListener()

        verifyBtn.setOnClickListener {
            val typeOTP = (inputOTP1.text.toString() + inputOTP2.text.toString() + inputOTP3.text.toString()
                         + inputOTP4.text.toString() + inputOTP5.text.toString() + inputOTP6.text.toString())

            if(typeOTP.isNotEmpty()){
                if (typeOTP.length == 6){
                    val credential : PhoneAuthCredential = PhoneAuthProvider.getCredential(
                        OTP, typeOTP
                    )
                    sendToMain()
                    progress.visibility = View.VISIBLE
                }else{
                    Toast.makeText(applicationContext,"Please Enter Correct OTP", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(applicationContext,"Enter OTP", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun init() {
        auth = FirebaseAuth.getInstance()
        verifyBtn = binding.verify
        inputOTP1 = binding.one
        inputOTP2 = binding.two
        inputOTP3 = binding.three
        inputOTP4 = binding.four
        inputOTP5 = binding.five
        inputOTP6 = binding.six
        progress = binding.progress
        progress.visibility = View.INVISIBLE
    }




    private fun sendToMain(){
        startActivity(Intent(this,bottomNavigationHomescreen::class.java))
        progress.visibility = View.INVISIBLE
    }

    private fun addTextChangeListener(){
        inputOTP1.addTextChangedListener (EditTextWatcher(inputOTP1))
        inputOTP2.addTextChangedListener (EditTextWatcher(inputOTP2))
        inputOTP3.addTextChangedListener (EditTextWatcher(inputOTP3))
        inputOTP4.addTextChangedListener (EditTextWatcher(inputOTP4))
        inputOTP5.addTextChangedListener (EditTextWatcher(inputOTP5))
        inputOTP6.addTextChangedListener (EditTextWatcher(inputOTP6))
    }

    inner class EditTextWatcher(private val view: View) : TextWatcher{
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun afterTextChanged(p0: Editable?) {
            val text = p0.toString()
            when(view.id){
                R.id.one -> if(text.length == 1) inputOTP2.requestFocus()
                R.id.two -> if(text.length == 1) inputOTP3.requestFocus() else if (text.isEmpty()) inputOTP1.requestFocus()
                R.id.three -> if(text.length == 1) inputOTP4.requestFocus() else if (text.isEmpty()) inputOTP2.requestFocus()
                R.id.four -> if(text.length == 1) inputOTP5.requestFocus() else if (text.isEmpty()) inputOTP3.requestFocus()
                R.id.five -> if(text.length == 1) inputOTP6.requestFocus() else if (text.isEmpty()) inputOTP4.requestFocus()
                R.id.six -> if (text.isEmpty()) inputOTP5.requestFocus()
            }
        }

    }

}
