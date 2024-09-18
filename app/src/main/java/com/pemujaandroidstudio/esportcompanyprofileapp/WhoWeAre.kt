package com.pemujaandroidstudio.esportcompanyprofileapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.ActivityWhoWeAreBinding

class WhoWeAre : AppCompatActivity() {
    private lateinit var binding: ActivityWhoWeAreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWhoWeAreBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}