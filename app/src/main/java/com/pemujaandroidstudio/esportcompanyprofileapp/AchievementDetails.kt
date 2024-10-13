package com.pemujaandroidstudio.esportcompanyprofileapp

import android.R
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.pemujaandroidstudio.esportcompanyprofileapp.AchievementData.achievements
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.ActivityAchievementDetailsBinding
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.ActivityMainBinding

class AchievementDetails : AppCompatActivity() {
    private lateinit var binding: ActivityAchievementDetailsBinding
    var currentAchievement = achievements;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAchievementDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val yearSpinner: Spinner = binding.yearspinner
        val years = arrayOf("All", "2022", "2023", "2024", "2025", "2026") // Add more years as needed

        val adapterSpinner = ArrayAdapter(this, R.layout.simple_spinner_item, years)
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        yearSpinner.adapter = adapterSpinner

        yearSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // Get the selected year
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
            achievements
        } else {
            achievements.filter {
                it.time.year.toString() == year // Filter based on selected year
            }.toTypedArray()
        }
        val adapter = AchievementAdapter(this, filteredList)
        binding.listView.adapter = adapter
    }
}