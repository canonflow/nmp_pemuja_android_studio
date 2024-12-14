package com.pemujaandroidstudio.esportcompanyprofileapp

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.ActivityTeamMemberDetailsBinding
import com.squareup.picasso.Picasso

class TeamMemberDetails : AppCompatActivity() {
    private lateinit var binding: ActivityTeamMemberDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamMemberDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listView = binding.member

        var game = intent.getStringExtra("GAME")
        if (game == null) {
            game = "Valorant"
        }
        var team = intent.getStringExtra("TEAM")


        val teamName = binding.teamName
        teamName.text = team.toString()

        val imageLink = GameData.games.firstOrNull { it.name.equals(game, true) }?.imageLink

        if (imageLink != null) {
            Picasso.get()
                .load(imageLink)
                .into(binding.gameBanner)
        } else {
            binding.gameBanner.setImageResource(R.drawable.banner_valorant)
        }

        TeamMemberData.initialize(this) {
            Log.d("TeamActivity", "TeamData : ${TeamMemberData.teamMembers.size}")
            var filteredTeamMembers: Array<TeamMemberBank> = filter(TeamMemberData.teamMembers, team, game)
            Log.d("TeamActivity", "Filtered Teams: ${filteredTeamMembers.size}")
            val adapter = TeamMemberAdapter(this, filteredTeamMembers)
            listView.adapter = adapter
            adapter.notifyDataSetChanged()
        }
    }
    
    fun filter(teamMembers:Array<TeamMemberBank>, team: String?, game: String?): Array<TeamMemberBank> {
        var filteredTeamMembers = teamMembers.filter { member ->
                val teamMatch = team?.let { member.team == it } ?: true
                val gameMatch = game?.let { member.game == it } ?: true
                teamMatch && gameMatch
            }.toTypedArray()
        return filteredTeamMembers
    }}