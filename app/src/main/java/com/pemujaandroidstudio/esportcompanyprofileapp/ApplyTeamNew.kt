package com.pemujaandroidstudio.esportcompanyprofileapp

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.ActivityApplyTeamBinding
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.ActivityApplyTeamNewBinding

class ApplyTeamNew : AppCompatActivity() {
    private lateinit var binding:ActivityApplyTeamNewBinding
    var selectedGame = "Valorant"

    fun setSpinnerTeam(){
        val teams = TeamData.teams.filter {
            it.game.equals(selectedGame,true)}
            .map{it.name}.toTypedArray()
        val adapterTeamSpinner = ArrayAdapter(this, R.layout.simple_spinner_item, teams)
        adapterTeamSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerTeam.adapter = adapterTeamSpinner
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityApplyTeamNewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val games = GameData.games.map{it.name}
        val adapterGameSpinner = ArrayAdapter(this, R.layout.simple_spinner_item, games)
        adapterGameSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerGame.adapter = adapterGameSpinner

        binding.spinnerGame.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedGame = games[position]
                setSpinnerTeam()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                selectedGame = "Valorant"
                setSpinnerTeam()
            }
        }

        val teams = TeamData.teams.filter {
            it.game.equals(selectedGame,true)}
            .map{it.name}.toTypedArray()
        val adapterTeamSpinner = ArrayAdapter(this, R.layout.simple_spinner_item, teams)
        adapterTeamSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerTeam.adapter = adapterTeamSpinner

        binding.btnApplyTeam.setOnClickListener {
            val selectedTeamName = teams[binding.spinnerTeam.selectedItemPosition]
            val description = binding.txtDescription.text.toString()
            val statusProposal = "Waiting"
            val newProposal = ProposalBank(selectedGame,selectedTeamName,description, statusProposal)

            val proposalList = ProposalData.proposals.toMutableList()
            proposalList.add(newProposal)
            ProposalData.proposals = proposalList.toTypedArray()

            finish()

            val intent = Intent(this, ApplyTeam::class.java)
            startActivity(intent)
        }
    }
}