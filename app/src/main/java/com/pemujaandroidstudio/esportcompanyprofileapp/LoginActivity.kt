package com.pemujaandroidstudio.esportcompanyprofileapp

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
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
import org.json.JSONObject

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
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.btnSignIn.setOnClickListener {
            username = binding.txtUsernameValue.text.toString() ?: ""
            val password = binding.txtPasswordValue.text.toString() ?: ""

            if(!username.equals("") && !password.equals("")){
//                val editor = sharedPreferences.edit()
//                editor.putString("USERNAME", username)
//                editor.apply()
//                val intent = Intent(this, MainActivity::class.java)
//                startActivity(intent)
//                finish()
                val q = Volley.newRequestQueue(it.context)
                val url = "https://ubaya.xyz/native/160422065/login.php"
                var stringRequest = object : StringRequest(
                    Request.Method.POST,
                    url,
                    {
                        Log.d("cek", it)
                        val obj = JSONObject(it)
                        val result = obj.getString("result")
                        val message = obj.getString("message")
                        if (result.equals("OK", false)) {
                            val editor = sharedPreferences.edit()
                            editor.putString("USERNAME", username)
                            editor.apply()
                            showDialog("Success", "Login Success", true, MainActivity::class.java)
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
                        return params
                    }
                }
                q.add(stringRequest)
            } else {
                showDialog("Failed", "Username or Password is empty")
            }
        }

        binding.btnSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
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