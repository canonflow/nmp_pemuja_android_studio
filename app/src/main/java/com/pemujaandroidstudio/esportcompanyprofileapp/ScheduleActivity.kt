package com.pemujaandroidstudio.esportcompanyprofileapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.ActivityScheduleBinding

class ScheduleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScheduleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScheduleBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.recSchedule.layoutManager = LinearLayoutManager(this)
        binding.recSchedule.setHasFixedSize(true)
        binding.recSchedule.adapter = ScheduleAdapter();


    }
}