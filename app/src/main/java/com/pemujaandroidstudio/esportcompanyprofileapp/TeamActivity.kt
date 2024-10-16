package com.pemujaandroidstudio.esportcompanyprofileapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.ActivityAchievementDetailsBinding
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.ActivityTeamBinding

class TeamActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTeamBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var game = intent.getStringExtra("GAME")
        if (game == null) {
            game = "Valorant"
        }

        // Change the image based on the game
        val imgId = this.resources.getIdentifier("banner_" + game.lowercase().replace(" ", "_"), "drawable", this.packageName)
        binding.imgTeamView.setImageResource(imgId)


        val listTeam = TeamData.teams.filter {
            it.game.equals(game, true)
        }.toTypedArray();

        val adapter = TeamAdapter(this, listTeam)
        binding.listView.adapter = adapter;

    }
}