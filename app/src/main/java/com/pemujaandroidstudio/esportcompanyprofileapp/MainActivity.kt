package com.pemujaandroidstudio.esportcompanyprofileapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.navigationLayout.toolbar)
        getSupportActionBar()!!.setTitle("E-Sport")

        val toggle = ActionBarDrawerToggle(
            this,
            binding.root,
            binding.navigationLayout.toolbar,
            R.string.open,
            R.string.close
        )
        toggle.isDrawerIndicatorEnabled = true
        binding.root.addDrawerListener(toggle)
        toggle.syncState()

        binding.navigationMenu.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.btnApplyTeam -> {
                    // Trigger Apply Team Disini
                    val intent = Intent(this, ApplyTeam::class.java)
                    startActivity(intent)
                    true
                }
                R.id.btnSignOut -> {
                    Toast.makeText(this, "Sign Out", Toast.LENGTH_SHORT).show()
                    // Clear SharedPreference
                    val settings: SharedPreferences = getSharedPreferences(
                        "SETTING", MODE_PRIVATE
                    )
                    settings.edit().remove("USERNAME").apply()

                    // Redirect to login page
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else -> true
            }
            true
        }

        setupViewPager()
        setupBottomNavigation()
    }

    private fun setupViewPager() {
        val fragments = listOf(
            WhatWePlayFragment(),
            ScheduleFragment(),
            WhoWeAreFragment()
        )

        binding.viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = fragments.size
            override fun createFragment(position: Int): Fragment = fragments[position]
        }

        // Synchronize ViewPager2 and BottomNavigationView
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.bottomNavigation.menu.getItem(position).isChecked = true
            }
        })
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_what_we_play -> binding.viewPager.currentItem = 0
                R.id.nav_schedule -> binding.viewPager.currentItem = 1
                R.id.nav_who_we_are -> binding.viewPager.currentItem = 2
            }
            true
        }
    }

}