package com.pemujaandroidstudio.esportcompanyprofileapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val sharedPreferences: SharedPreferences =
            getSharedPreferences("SETTING", Context.MODE_PRIVATE)
        var username = sharedPreferences.getString("USERNAME",
            "").toString()
        if(!username.equals("")){
            val intent = Intent(this, WhatWePlayActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.btnSignIn.setOnClickListener {
            username = binding.txtUsernameValue.text.toString() ?: ""
            val password = binding.txtPasswordValue.text.toString() ?: ""

            if(!username.equals("") && !password.equals("")){
                val editor = sharedPreferences.edit()
                editor.putString("USERNAME", username)
                editor.apply()
                val intent = Intent(this, WhatWePlayActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        binding.btnSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


}