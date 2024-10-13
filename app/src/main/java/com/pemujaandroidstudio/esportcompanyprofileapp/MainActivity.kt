package com.pemujaandroidstudio.esportcompanyprofileapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.BindingAdapter
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonViewWhoWeAre.setOnClickListener {
            val intent = Intent(this, WhoWeAre::class.java)

            startActivity(intent)
        }

        binding.btnOutSchedule.setOnClickListener {
            val intent = Intent(this, ScheduleActivity::class.java)

            startActivity(intent)
        }

        binding.buttonWhatWePlay.setOnClickListener {
            val intent = Intent(this, AchievementDetails::class.java)
            startActivity(intent);
        }
    }

}