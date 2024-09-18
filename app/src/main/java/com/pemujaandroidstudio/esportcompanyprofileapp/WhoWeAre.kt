package com.pemujaandroidstudio.esportcompanyprofileapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.ActivityWhoWeAreBinding

class WhoWeAre : AppCompatActivity() {
    private lateinit var binding: ActivityWhoWeAreBinding

    companion object {
        private var LIKE: Int = 15
        private var IS_LIKED: Boolean = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWhoWeAreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.likeCounter.text = LIKE.toString()

        if (IS_LIKED) {
            binding.btnLike.isEnabled = false
            binding.btnLike.isClickable = false;
        }

        binding.btnLike.setOnClickListener {
            LIKE++
            IS_LIKED = true
            binding.btnLike.isEnabled = false
            binding.btnLike.isClickable = false;
            binding.likeCounter.text = LIKE.toString()
        }

    }
}