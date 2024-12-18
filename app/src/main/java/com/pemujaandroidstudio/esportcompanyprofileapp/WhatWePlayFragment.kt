package com.pemujaandroidstudio.esportcompanyprofileapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.FragmentWhatWePlayBinding

class WhatWePlayFragment : Fragment() {

    private lateinit var binding: FragmentWhatWePlayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWhatWePlayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var adapter = GameAdapter()
        binding.recGames.layoutManager = LinearLayoutManager(requireContext())
        binding.recGames.adapter = adapter
        binding.recGames.setHasFixedSize(true)

        GameData.initialize(requireContext()) {
            adapter.notifyDataSetChanged()
        }
    }
}
