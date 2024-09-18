package com.pemujaandroidstudio.esportcompanyprofileapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.ActivityScheduleDetailBinding

class ScheduleDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScheduleDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScheduleDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnNotif.setOnClickListener {
            Toast.makeText(this, "Notification Created", Toast.LENGTH_SHORT)
                .show()
        }

    }
}