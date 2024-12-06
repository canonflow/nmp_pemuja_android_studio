package com.pemujaandroidstudio.esportcompanyprofileapp

import android.content.Intent
import android.os.Bundle
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
        binding.recProposal.adapter = ProposalAdapter()

        binding.btnApplyTeamNew.setOnClickListener {
            val intent = Intent(this, ApplyTeamNew::class.java)
            startActivity(intent)
        }
    }
}