package com.pemujaandroidstudio.esportcompanyprofileapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.ActivityScheduleDetailBinding
import com.squareup.picasso.Picasso

class ScheduleDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScheduleDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScheduleDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val title = intent.getStringExtra("TITLE")
        val game = intent.getStringExtra("GAME")
        val team = intent.getStringExtra("TEAM")
        val description = intent.getStringExtra("DESCRIPTION")
        val timeAndLocation = intent.getStringExtra("TIME_AND_LOCATION")
        val image = intent.getStringExtra("IMAGE")

        Picasso.get()
            .load(image)
            .into(binding.imageView)
        binding.txtTitle.text = title
        binding.txtTeam.text = team
        binding.txtGame.text = game
        binding.txtLocationAndTime.text = timeAndLocation
        binding.txtDescription.text = description

        binding.btnNotif.setOnClickListener {
            Toast.makeText(this, "Notification Created", Toast.LENGTH_SHORT)
                .show()
        }

    }
}