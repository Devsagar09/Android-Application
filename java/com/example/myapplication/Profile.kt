package com.example.myapplication

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.graphics.*
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.transition.Transition
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import coil.load
import coil.transform.CircleCropTransformation
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.security.MessageDigest

@Suppress("DEPRECATION", "UNREACHABLE_CODE")
open class Profile : Fragment() {
    private lateinit var auth: FirebaseAuth
    private var database: FirebaseDatabase? = null
    private lateinit var builder: AlertDialog.Builder
    private var databaseReference: DatabaseReference? = null
    private var firebaseStorage : FirebaseStorage? =null
    private lateinit var storageReference: StorageReference
    private var user: User? = null
    private var uid: String? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_profile, container, false)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.getReference()!!.child("Users")
        firebaseStorage = FirebaseStorage.getInstance()
        storageReference = FirebaseStorage.getInstance().reference
        uid = FirebaseAuth.getInstance().uid

        getUserData()

//        database!!.reference.child("Users")
//            .addValueEventListener(object : ValueEventListener{
//                override fun onDataChange(snapshot: DataSnapshot) {
//                    userList.clear()
//                    for (snapshot1 in snapshot.children){
//                        val user = snapshot1.getValue(User::class.java)
//                        if (user!!.uid != FirebaseAuth.getInstance().uid){
//                            userList.add(user)
//                        }
//                    }
//                }
//
//                override fun onCancelled(error: DatabaseError) {
//                    Toast.makeText(activity,"Failed to get Data", Toast.LENGTH_SHORT).show()
//                }
//
//            })
//        uid = auth.currentUser?.uid.toString()

//        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
//        if(uid.isNotEmpty()){
//            getUserData()
//        }



        builder = AlertDialog.Builder(activity)
        view.findViewById<Button>(R.id.logout).setOnClickListener {
            auth.signOut()
            val message = "Do you want to Log Out?"
            showCustomDialogBox(message)
        }

        view.findViewById<TextView>(R.id.aboutbtn).setOnClickListener {
            aboutus()
        }
        return view

    }

    private fun getUserData() {
        Log.e("Data------->", uid?: "")
        databaseReference?.child(uid?: "")?.addValueEventListener(object : ValueEventListener {
            @SuppressLint("CheckResult", "UseRequireInsteadOfGet", "SuspiciousIndentation")
            override fun onDataChange(snapshot: DataSnapshot) {
                val name = view!!.findViewById<TextView>(R.id.username)
                val email = view!!.findViewById<TextView>(R.id.mail_id)
                val profile = view!!.findViewById<ImageView>(R.id.profile)

                user = snapshot.getValue(User::class.java)!!
                name.text = user?.name
                email.text = user?.email

                    Glide.with(requireContext())
                        .load(user!!.imageUrl?.toUri())
                        .placeholder(R.drawable.upload)
                        .apply(RequestOptions.bitmapTransform(CircleCrop()))
                        .into(profile)
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(activity, "Failed to get Data", Toast.LENGTH_SHORT).show()
            }
        })
    }



    @SuppressLint("SuspiciousIndentation")
    private fun showCustomDialogBox(message: String?) {
        val dialog = activity?.let { Dialog(it) }
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCancelable(true)
        dialog?.setContentView(R.layout.custom_dialog)
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        val window = dialog?.window
        window?.setGravity(Gravity.CENTER)
        window?.attributes?.windowAnimations = R.style.dialoganimation

        val txtmessage: TextView? = dialog?.findViewById(R.id.message)
        val btnyes: Button? = dialog?.findViewById(R.id.yes)
        val btnno: Button? = dialog?.findViewById(R.id.no)

        txtmessage?.text = message
        btnyes?.setOnClickListener {
            val intent = Intent(activity, MainActivity3::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(activity).toBundle())
            activity?.finish()
        }

        btnno?.setOnClickListener { dialog.dismiss() }

        dialog?.show()
    }

    private fun aboutus(){
        val dialog = activity?.let { Dialog(it) }
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCancelable(false)
        dialog?.setContentView(R.layout.aboutus)
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        val window = dialog?.window
        window?.setGravity(Gravity.CENTER)

        val close: TextView? = dialog?.findViewById(R.id.close)

        close?.setOnClickListener { dialog.dismiss() }
        dialog?.show()
    }


}
