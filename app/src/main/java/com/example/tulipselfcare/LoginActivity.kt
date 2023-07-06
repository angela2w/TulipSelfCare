package com.example.tulipselfcare

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    lateinit var etEmail : EditText
    lateinit var etPassword : EditText
    lateinit var tvRedirectSignIn_user : TextView
    lateinit var btnLogin : Button

    lateinit var auth : FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etEmail=findViewById(R.id.Et_Email)
        etPassword=findViewById(R.id.et_AppFee)
        tvRedirectSignIn_user=findViewById(R.id.tvRedirectlogin_user)
        btnLogin=findViewById(R.id.btn_AppBookAppointment)
        auth= FirebaseAuth.getInstance()

        tvRedirectSignIn_user.setOnClickListener {
            var intent = Intent(this, StartActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
            finish()

        }
        btnLogin.setOnClickListener {

        }


    }
}