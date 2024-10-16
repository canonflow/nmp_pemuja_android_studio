package com.pemujaandroidstudio.esportcompanyprofileapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.ActivityTeamMemberDetailsBinding

class TeamMemberDetails : AppCompatActivity() {
    private lateinit var binding: ActivityTeamMemberDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamMemberDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val listView = findViewById<ListView>(R.id.member)
        val listView = binding.member

        var game = intent.getStringExtra("GAME")
        if (game == null) {
            game = "Valorant"
        }
        var team = intent.getStringExtra("TEAM")


//        val teamName = findViewById<TextView>(R.id.teamName)
        val teamName = binding.teamName
//        teamName.setText(team.toString())
        teamName.text = team.toString()

//        val banner = findViewById<ImageView>(R.id.gameBanner)
        val banner = binding.gameBanner
        val imgId = this.resources.getIdentifier("banner_" + game.lowercase().replace(" ", "_"), "drawable", this.packageName)
        banner.setImageResource(imgId)

        var filteredTeamMembers: Array<TeamMemberBank> = filter(TeamMemberData.teamMembers, team, game)
        val adapter = TeamMemberAdapter(this, filteredTeamMembers)
        listView.adapter = adapter
    }
    
    fun filter(teamMembers:Array<TeamMemberBank>, team: String?, game: String?): Array<TeamMemberBank> {
        var filteredTeamMembers = teamMembers.filter { member ->
                val teamMatch = team?.let { member.team == it } ?: true
                val gameMatch = game?.let { member.game == it } ?: true
                teamMatch && gameMatch
            }.toTypedArray()
        return filteredTeamMembers
    }}