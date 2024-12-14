package com.pemujaandroidstudio.esportcompanyprofileapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.ActivityApplyTeamNewBinding
import org.json.JSONObject

class ApplyTeamNew : AppCompatActivity() {
    private lateinit var binding: ActivityApplyTeamNewBinding
    private var isGameDataInitialized = false
    private var isTeamDataInitialized = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityApplyTeamNewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences: SharedPreferences = getSharedPreferences("SETTING", Context.MODE_PRIVATE)
        var username = sharedPreferences.getString("USERNAME", "").toString()

        GameData.initialize(this) {
            Log.d("GameData", "Games initialized: ${GameData.games.map { it.name }}")
            isGameDataInitialized = true
            checkInitializationAndSetup()
        }

        TeamData.initialize(this) {
            Log.d("TeamData", "Teams initialized: ${TeamData.teams.map { "${it.name} - ${it.game}" }}")
            isTeamDataInitialized = true
            checkInitializationAndSetup()
        }

        binding.btnApplyTeam.setOnClickListener {
            submitProposal(username)
            val intent = Intent(this, ApplyTeam::class.java)
            startActivity(intent)
        }
    }

    private fun checkInitializationAndSetup() {
        if (isGameDataInitialized && isTeamDataInitialized) {
            setupSpinners()
        } else {
            Log.d("InitializationStatus", "Waiting for initialization: GameData=$isGameDataInitialized, TeamData=$isTeamDataInitialized")
        }
    }

    private fun setupSpinners() {
        if (!GameData.isInitialized || !TeamData.isInitialized) {
            Log.d("InitializationStatus", "Waiting for initialization: GameData=${GameData.isInitialized}, TeamData=${TeamData.isInitialized}")
            return
        }

        val existingProposals = ProposalData.proposals.map { Pair(it.team, it.game) }.toSet()
        Log.d("ProposalData", "Existing Proposals: $existingProposals")

        val filteredGames = GameData.games
            .filter { game ->
                TeamData.teams.any { team ->
                    team.game.equals(game.name, true) &&
                            !(existingProposals.contains(Pair(team.name, team.game)))
                }
            }
            .map { it.name }
            .toTypedArray()
        if (filteredGames.isEmpty()) {
            // Show a message and disable the page functionality
            Toast.makeText(this, "No available games with eligible teams.", Toast.LENGTH_LONG).show()
            disablePage()
            return
        }

        Log.d("FilteredGames", "Filtered Games: ${filteredGames.joinToString()}")

        val adapterGameSpinner = ArrayAdapter(this, android.R.layout.simple_spinner_item, filteredGames)
        adapterGameSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerGame.adapter = adapterGameSpinner

        binding.spinnerGame.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedGame = filteredGames[position]
                setSpinnerTeam(selectedGame, existingProposals)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                val selectedGame = if (filteredGames.isNotEmpty()) filteredGames[0] else "No Game Available"
                setSpinnerTeam(selectedGame, existingProposals)
            }
        }
    }

    private fun setSpinnerTeam(selectedGame: String, existingProposals: Set<Pair<String, String>>) {
        // Filter teams based on the selected game and existing proposals
        val filteredTeams = TeamData.teams
            .filter { it.game.equals(selectedGame, true) && !(existingProposals.contains(Pair(it.name, it.game))) }
            .map { it.name }
            .toTypedArray()

        Log.d("FilteredTeams", "Teams for Game $selectedGame: ${filteredTeams.joinToString()}")

        val adapterTeamSpinner = ArrayAdapter(this, android.R.layout.simple_spinner_item, filteredTeams)
        adapterTeamSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerTeam.adapter = adapterTeamSpinner
    }
    private fun disablePage() {
        // Disable both spinners and the apply button
        binding.spinnerGame.isEnabled = false
        binding.spinnerTeam.isEnabled = false
        binding.btnApplyTeam.isEnabled = false
        binding.txtApplyTeam.isEnabled = false

        // Optionally clear the team spinner
        val emptyAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayOf("No Teams Available"))
        emptyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerTeam.adapter = emptyAdapter
    }

    private fun submitProposal(username: String) {
        val url = "https://ubaya.xyz/native/160422065/insert_proposals.php"
        val queue = Volley.newRequestQueue(this)

        val stringRequest = object : StringRequest(
            Request.Method.POST,
            url,
            { response ->
                val obj = JSONObject(response)
                if (obj.getString("result") == "OK") {
                    Log.d("Proposal", "Success: ${obj.getString("message")}")
                } else {
                    Log.d("Proposal", "Error: ${obj.getString("message")}")
                }
                updateSpinners()
            },
            { error ->
                Log.e("Proposal", "Volley Error: ${error.message}")
            }
        ) {
            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String, String>()
                params["team_name"] = binding.spinnerTeam.selectedItem.toString()
                params["game"] = binding.spinnerGame.selectedItem.toString()
                params["description"] = binding.txtDescription.text.toString()
                params["username"] = username
                params["status"] = "Waiting"
                return params
            }
        }
        queue.add(stringRequest)
    }

    private fun updateSpinners() {
        if (isGameDataInitialized && isTeamDataInitialized) {
            setupSpinners()
        }
    }
}
