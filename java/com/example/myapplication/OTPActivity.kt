package com.example.myapplication

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityOtpactivityBinding
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import java.util.concurrent.TimeUnit

@Suppress("DEPRECATION")
class OTPActivity : AppCompatActivity() {
    private lateinit var getotp : Button
    private lateinit var mobileno : EditText
    private lateinit var auth : FirebaseAuth
    private lateinit var number :String
    private lateinit var progressBar: ProgressBar
    private lateinit var binding: ActivityOtpactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backbtn2.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        init()

        getotp.setOnClickListener {
            number = mobileno.text.trim().toString()
            if(number.isNotEmpty()){
                if(number.length == 10){
                    number = "+91$number"
                    progressBar.visibility = View.VISIBLE
                    val options = PhoneAuthOptions.newBuilder(auth)
                        .setPhoneNumber(number)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(callbacks)          // OnVerificationStateChangedCallbacks
                        .build()
                    PhoneAuthProvider.verifyPhoneNumber(options)

                    sendToMain()

                }else{
                    Toast.makeText(applicationContext,"Incorrect Mobile number", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(applicationContext,"Enter Mobile Number", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun init(){
        progressBar = binding.progress
        progressBar.progressTintList = ColorStateList.valueOf(Color.BLUE);
        progressBar.visibility = View.INVISIBLE
        getotp = binding.getotp
        mobileno = binding.mobileno
        auth = FirebaseAuth.getInstance()
    }

    private fun sendToMain(){
        startActivity(Intent(this,VerifyOTP::class.java))
    }



    private val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        override fun onVerificationCompleted(credential: PhoneAuthCredential) {
            // This callback will be invoked in two situations:
            // 1 - Instant verification. In some cases the phone number can be instantly
            //     verified without needing to send or enter a verification code.
            // 2 - Auto-retrieval. On some devices Google Play services can automatically
            //     detect the incoming verification SMS and perform verification without
            //     user action.
            Log.e("SendOTP", "onVerificationCompleted: $credential")
        }

        override fun onVerificationFailed(e: FirebaseException) {
            // This callback is invoked in an invalid request for verification is made,
            // for instance if the the phone number format is not valid.



        }

        override fun onCodeSent(
            verificationId: String,
            token: PhoneAuthProvider.ForceResendingToken
        ) {
            intent = Intent(applicationContext, VerifyOTP::class.java)
            intent.putExtra("OTP",verificationId)
            intent.putExtra("resendToken",token)
            intent.putExtra("phoneNumber",number)
            intent.putExtra("Mobile",mobileno.text.toString())
            startActivity(intent)
            progressBar.visibility = View.INVISIBLE
        }
    }
}

//remove signupwithpohone function and in onVerificationCompleted just add intent for the next activity

