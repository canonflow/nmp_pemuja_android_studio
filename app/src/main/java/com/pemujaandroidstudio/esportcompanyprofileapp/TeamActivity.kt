package com.pemujaandroidstudio.esportcompanyprofileapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.ActivityAchievementDetailsBinding
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.ActivityTeamBinding
import com.squareup.picasso.Picasso

class TeamActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTeamBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var game = intent.getStringExtra("GAME")
        var image = intent.getStringExtra("IMAGE")
        if (game == null) {
            game = "Valorant"
        }
        Log.d("TeamActivity", "Game received: $game")

        Picasso.get()
            .load(image)
            .into(binding.imgTeamView)

        TeamData.initialize(this) {
            Log.d("TeamActivity", "TeamData : ${TeamData.teams.size}")
            val listTeam = TeamData.teams.filter {
                it.game.equals(game, true)
            }.toTypedArray();
            Log.d("TeamActivity", "Filtered Teams: ${listTeam.size}")
            val adapter = TeamAdapter(this, listTeam)
            binding.listView.adapter = adapter;
            adapter.notifyDataSetChanged()
        }
    }
}