package com.pemujaandroidstudio.esportcompanyprofileapp

import android.R
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.pemujaandroidstudio.esportcompanyprofileapp.AchievementData.achievements
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.ActivityAchievementDetailsBinding
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class AchievementDetails : AppCompatActivity() {
    private lateinit var binding: ActivityAchievementDetailsBinding
    private lateinit var game: String
    var currentAchievement = achievements;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAchievementDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        game = intent.getStringExtra("GAME").toString()

        val imageLink = GameData.games.firstOrNull { it.name.equals(game, true) }?.imageLink

        if (imageLink != null) {
            Picasso.get()
                .load(imageLink)
                .into(binding.imageView)
        } else {
            binding.imageView.setImageResource(com.pemujaandroidstudio.esportcompanyprofileapp.R.drawable.banner_valorant)
        }

        AchievementData.initialize(this) {
            Log.d("AchievementActivity", "AchievementData : ${TeamMemberData.teamMembers.size}")
            val adapter = AchievementAdapter(this, AchievementData.achievements)
            binding.listView.adapter = adapter
            adapter.notifyDataSetChanged()
        }

        val yearSpinner: Spinner = binding.yearspinner
        val years = arrayOf("All", "2022", "2023", "2024", "2025", "2026") // Add more years as needed

        val adapterSpinner = ArrayAdapter(this, R.layout.simple_spinner_item, years)
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        yearSpinner.adapter = adapterSpinner

        yearSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedYear = parent.getItemAtPosition(position).toString()
                UpdateAchiements(selectedYear)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Handle when nothing is selected, if needed
            }
        }
    }
    fun UpdateAchiements(year: String)
    {
        val filteredList:Array<AchievementBank> = if (year == "All") {
            achievements.filter {
                it.game.equals(game, true)
            }.toTypedArray()
        } else {
            achievements.filter {
                it.time.year.toString() == year && // Filter based on selected year
                it.game.equals(game, true)
            }.toTypedArray()
        }
        val adapter = AchievementAdapter(this, filteredList)
        binding.listView.adapter = adapter
    }
}