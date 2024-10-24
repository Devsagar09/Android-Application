package com.example.myapplication

import android.annotation.SuppressLint
import android.app.*
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.view.Gravity
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import coil.load
import coil.transform.CircleCropTransformation
import com.example.myapplication.databinding.ActivitySignupBinding
import com.google.firebase.auth.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.karumi.dexter.listener.single.PermissionListener
import java.text.SimpleDateFormat
import java.util.*
import android.net.Uri as Uri1

@Suppress("DEPRECATION", "CAST_NEVER_SUCCEEDS")
open class signupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private var storageReference: StorageReference? = null
    private var filePath: Uri1? = null
    private lateinit var database: DatabaseReference
    private val CHANNEL_ID = "channel_id_example_01"
    private val notificationId = 101
    private val CAMERA_REQUEST_CODE = 1
    private val GALLERY_REQUEST_CODE = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        storageReference = FirebaseStorage.getInstance().reference

        binding.backbtn2.setOnClickListener() {
            onBackPressedDispatcher.onBackPressed()
        }


        binding.Upload.setImageURI(null)
        binding.creatAc.setOnClickListener {

            val name = binding.name.text.toString()
            val email = binding.email.text.toString()
            val pass = binding.psw.text.toString()
            val confirmpass = binding.cpsw.text.toString()


            if (name.isNotEmpty() && email.isNotEmpty()  && pass.isNotEmpty() && confirmpass.isNotEmpty()) {
                if (pass == confirmpass) {

                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {

                        sendNotification()
                        val progressDialog = Dialog(this)
                        progressDialog.setContentView(R.layout.workprogress)
                        progressDialog.setCancelable(false)
                        progressDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
                        if (it.isSuccessful) {
                            intent = Intent(applicationContext, OTPActivity::class.java)
                            startActivity(intent)
                            uploadimg()
                            progressDialog.show()
                        }

                        else if (!email.contains("@")) {
                            Toast.makeText(
                                applicationContext,
                                "check your email address",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                        else if (pass.length < 6) {
                            Toast.makeText(
                                applicationContext,
                                "password must be at-least 6 digits",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                applicationContext,
                                "Something went wrong",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } else {
                    Toast.makeText(applicationContext, "Password not Match", Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                Toast.makeText(applicationContext, "Empty Field is not Allow ", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        binding.Upload.setOnClickListener {
            ChooseImage()
//            val pictureDialog = AlertDialog.Builder(this)
//            pictureDialog.setTitle("Select Action")
//            val pictureDialogItem = arrayOf(
//                "Capture photo from Camera",
//                "Select photo from File"
//            )
//            pictureDialog.setItems(pictureDialogItem) { dialog, which ->
//                when (which) {
//                    0 -> cameraCheckPermission()
//                    1 -> galleryCheckPermission()
//                }
//            }
//
//            pictureDialog.show()
        }

        createNotificationChannel()
    }

    private fun uploadData(imageUrl:String) {
        database = FirebaseDatabase.getInstance().getReference("Users")
        val User = User(
            firebaseAuth.uid.toString(),
            binding.name.text.toString(),
            binding.email.text.toString(),
            imageUrl,
            binding.psw.text.toString()
        )

//        database.ref.child("Users")
//            .child(firebaseAuth.uid.toString())
//            .setValue(User)

        database.child(firebaseAuth.uid.toString()).setValue(User).addOnSuccessListener {
            binding.name.text.clear()
            binding.email.text.clear()
            binding.psw.text.clear()

//                Toast.makeText(applicationContext, "Update", Toast.LENGTH_SHORT)
//                    .show()
        }.addOnFailureListener {
            Toast.makeText(applicationContext, "Fail", Toast.LENGTH_SHORT)
                .show()
        }
    }

//upload image on firebase is not working
    private fun uploadimg() {
        val formatter = SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault())
        val now = Date()
        val fileName = formatter.format(now)

        if (filePath != null) {

            val ref: StorageReference = FirebaseStorage.getInstance().reference
                .child("ProfilePic/$fileName")

            ref.putFile(filePath!!).addOnCompleteListener{
                if (it.isSuccessful){
                    ref.downloadUrl.addOnSuccessListener {task ->
                        uploadData(task.toString())
                    }
                }
            }

//                .addOnSuccessListener {
//                    val result = it.metadata!!.reference!!.downloadUrl
//                    result.addOnSuccessListener { uri ->
//                        val imageLink = uri.toString()
//                        Log.e("Imageupload", "uploadimg: $imageLink")
//                    }
//
////                    Toast.makeText(applicationContext, "Image Uploaded..", Toast.LENGTH_SHORT).show()
//                }
//                .addOnFailureListener {exception ->
////                    Toast.makeText(applicationContext, "Fail to Upload Image..", Toast.LENGTH_SHORT)
////                        .show()
//                    Log.e("Imageupload", "uploadimg: ${exception.message}")
//                }
        }
    }



    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Notification Title"
            val descriptionText = "Notification Description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    @SuppressLint("MissingPermission", "InlinedApi")
    private fun sendNotification() {

        val intent = Intent(this, bottomNavigationHomescreen::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pendingIntent: PendingIntent =
            PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("i-Droid : E Learning")
            .setContentText("Welcome to E-Learning Application").setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("Now, You can learn Mobile Application Development with us, We can teach you with the help of Notes and Youtube Videos.")
            )
            .setSmallIcon(R.mipmap.ic_launcher)
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .setContentIntent(pendingIntent)
            .setDefaults(Notification.DEFAULT_LIGHTS)
            .setAutoCancel(true)

        with(NotificationManagerCompat.from(this)) {
            notify(notificationId, builder.build())
        }
    }

    private fun galleryCheckPermission() {
        Dexter.withContext(this).withPermission(
            android.Manifest.permission.READ_EXTERNAL_STORAGE
        ).withListener(object : PermissionListener {
            override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                gallery()
            }

            override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                Toast.makeText(
                    this@signupActivity,
                    "You have denied the storage permission to select image",
                    Toast.LENGTH_SHORT
                ).show()

                showRotationalDialogForPermission()
            }

            override fun onPermissionRationaleShouldBeShown(
                p0: PermissionRequest?, p1: PermissionToken?
            ) {
                showRotationalDialogForPermission()
            }
        }).onSameThread().check()
    }

    private fun gallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, GALLERY_REQUEST_CODE)
    }

    private fun cameraCheckPermission() {
        Dexter.withContext(this)
            .withPermissions(
                android.Manifest.permission.READ_EXTERNAL_STORAGE,
                android.Manifest.permission.CAMERA
            ).withListener(
                object : MultiplePermissionsListener {
                    override fun onPermissionsChecked(report: MultiplePermissionsReport?) {
                        report?.let {

                            if (report.areAllPermissionsGranted()) {
                                camera()
                            }
                        }
                    }

                    override fun onPermissionRationaleShouldBeShown(
                        p0: MutableList<PermissionRequest>?,
                        p1: PermissionToken?
                    ) {
                        showRotationalDialogForPermission()
                    }

                }
            ).onSameThread().check()
    }

    private fun camera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, CAMERA_REQUEST_CODE)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {

            when (requestCode) {

                CAMERA_REQUEST_CODE -> {
                    val bitmap = data?.extras?.get("data") as Bitmap

                    binding.Upload.load(bitmap) {
                        crossfade(true)
                        crossfade(1000)
                        transformations(CircleCropTransformation())
                        filePath = data.data
                    }
                }

                GALLERY_REQUEST_CODE -> {
                    binding.Upload.load(data?.data) {
                        crossfade(true)
                        crossfade(1000)
                        transformations(CircleCropTransformation())
                        filePath = data?.data
                    }
                }

            }
        }
    }

    private fun ChooseImage(){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.chooseprofile)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        val window = dialog.window
        window?.setGravity(Gravity.CENTER)
//        window?.attributes?.windowAnimations = R.style.dialoganimation2 //put fade or zoom in-out animation

        val camera: CardView = dialog.findViewById(R.id.camera)
        val gallery: CardView = dialog.findViewById(R.id.gallery)

        camera.setOnClickListener {
            cameraCheckPermission()
        }

        gallery.setOnClickListener {
            galleryCheckPermission()
        }
        dialog.show()
    }

    private fun showRotationalDialogForPermission() {
        AlertDialog.Builder(this)
            .setMessage("It looks like you have turned off permissions" + "required for this feature. It can be enable under App settings")
            .setPositiveButton("Go to Settings") { _, _ ->

                try {
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    val uri = Uri1.fromParts("package", packageName, null)
                    intent.data = uri
                    startActivity(intent)
                } catch (e: ActivityNotFoundException) {
                    e.printStackTrace()
                }

            }.setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }.show()
    }

}