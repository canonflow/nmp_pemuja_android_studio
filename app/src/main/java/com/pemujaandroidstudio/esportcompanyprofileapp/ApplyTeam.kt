package com.pemujaandroidstudio.esportcompanyprofileapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.ActivityApplyTeamBinding
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.ActivityLoginBinding

class ApplyTeam : AppCompatActivity() {
    private lateinit var binding:ActivityApplyTeamBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityApplyTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recProposal.layoutManager = LinearLayoutManager(this)
        binding.recProposal.setHasFixedSize(true)
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("SETTING", Context.MODE_PRIVATE)
        var username = sharedPreferences.getString("USERNAME",
            "").toString()
        Log.d("ApplyTeam", username)
        ProposalData.initialize(this, username) {
            Log.d("ApplyTeam", "Proposals successfully initialized.")
            binding.recProposal.adapter = ProposalAdapter()
        }
        binding.btnApplyTeamNew.setOnClickListener {
            val intent = Intent(this, ApplyTeamNew::class.java)
            startActivity(intent)
        }
    }
}