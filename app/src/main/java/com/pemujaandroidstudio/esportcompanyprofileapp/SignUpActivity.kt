package com.pemujaandroidstudio.esportcompanyprofileapp

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.ActivityLoginBinding
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.ActivitySignUpBinding
import org.json.JSONObject

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
                val q = Volley.newRequestQueue(it.context)
                val url = "https://ubaya.xyz/native/160422065/register.php"
                var stringRequest = object : StringRequest(
                    Request.Method.POST,
                    url,
                    {
                        Log.d("cek", it)
                        val obj = JSONObject(it)
                        val result = obj.getString("result")
                        val message = obj.getString("message")
                        if (result.equals("OK", false)) {
                            showDialog("Success", message, true, LoginActivity::class.java);
                        } else {
                            showDialog("Failed", message)
                        }
                    },
                    {
                        Log.d("cek", it.message.toString())
                    }
                )
                {
                    override fun getParams(): MutableMap<String, String> {
                        val params = HashMap<String, String>()
                        params["username"] = username
                        params["password"] = password
                        params["fname"] = firstname
                        params["lname"] = lastname
                        return params
                    }
                }
                q.add(stringRequest)
            } else {
                showDialog("Failed", "Password doesn't match")
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

    fun showDialog(title: String, message: String, callback: Boolean = false, activity: Class<out AppCompatActivity>? = null) {
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK") { _, _ ->
                if (callback && activity != null) {
                    val intent = Intent(this, activity)
                    startActivity(intent)
                    finish()
                }
            }
            .show()
    }
}