package com.pemujaandroidstudio.esportcompanyprofileapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.ActivityWhatWePlayBinding

class WhatWePlayActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWhatWePlayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWhatWePlayBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.recGames.layoutManager = LinearLayoutManager(this)
        binding.recGames.adapter = GameAdapter()
        binding.recGames.setHasFixedSize(true)

    }
}