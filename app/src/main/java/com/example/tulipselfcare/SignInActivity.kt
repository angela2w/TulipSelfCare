package com.example.tulipselfcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignInActivity : AppCompatActivity() {

    lateinit var etUserName: EditText
    lateinit var etName : EditText
    lateinit var etEmail : EditText
    lateinit var etPassword : EditText
    lateinit var tvRedirectLogin_user : TextView
    lateinit var btnSignin : Button
    lateinit var auth : FirebaseAuth
    lateinit var RootRef : DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_sign_in)

        etUserName=findViewById(R.id.et_AppName)
        etName=findViewById(R.id.et_AppAddress)
        etEmail=findViewById(R.id.et_AppContact)
        etPassword=findViewById(R.id.et_AppFee)
        tvRedirectLogin_user=findViewById(R.id.tvRedirectlogin_user)
        btnSignin=findViewById(R.id.btn_AppBookAppointment)

        auth = FirebaseAuth.getInstance()
        RootRef = FirebaseDatabase.getInstance().getReference()

        btnSignin.setOnClickListener {
            SignUpUser()
        }

        tvRedirectLogin_user.setOnClickListener {
            var intent = Intent(this, StartActivity::class.java)
            startActivity(intent)

        }

        }
    private fun SignUpUser(){
        val username= etUserName.text.toString()
        val name=etName.text.toString()
        val email=etEmail.text.toString()
        val pass=etPassword.text.toString()
        if (username.isBlank() || name.isBlank() || email.isBlank() || pass.isBlank()){
            Toast.makeText(this,"Empty credentials!", Toast.LENGTH_SHORT).show()
            return
        } else if (etPassword.length() < 6){
            Toast.makeText(this,"Password to short", Toast.LENGTH_SHORT).show()
            return
        }else {
            signinUser(username,name,email,pass)
        }

    }

    private fun signinUser(username: String, name: String, email: String, pass: String) {
        auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener {
            if (it.isSuccessful){
            }
        }
    }


}
