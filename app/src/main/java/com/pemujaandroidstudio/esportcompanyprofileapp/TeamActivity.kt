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


        val listTeam:Array<TeamBank>;
        val adapter = TeamAdapter(this, listTeam)
        binding.listView.adapter = adapter

    }
}