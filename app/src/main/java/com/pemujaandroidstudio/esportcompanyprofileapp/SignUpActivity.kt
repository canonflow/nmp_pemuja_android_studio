package com.pemujaandroidstudio.esportcompanyprofileapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.ActivityLoginBinding
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmitSignUp.setOnClickListener {
            val firstname = binding.txtFirstName.text.toString()
            val lastname = binding.txtLastName.text.toString()
            val username = binding.txtUsernameSignUp.text.toString()
            val password = binding.txtPasswordSignUp.text.toString()
            val passwordrepeat = binding.txtPasswordRepeatSignUp.text.toString()
            if (password == passwordrepeat) {

            }
        }
        binding.checkBoxAgree.setOnCheckedChangeListener {
            _, isChecked -> binding.btnSubmitSignUp.isEnabled = isChecked
        }

        binding.btnBackSignUp.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}