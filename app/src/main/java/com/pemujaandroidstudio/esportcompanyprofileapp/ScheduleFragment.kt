package com.pemujaandroidstudio.esportcompanyprofileapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.FragmentScheduleBinding

class ScheduleFragment : Fragment() {

    private lateinit var binding: FragmentScheduleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScheduleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recSchedule.layoutManager = LinearLayoutManager(requireContext())
        binding.recSchedule.setHasFixedSize(true)

        ScheduleData.initialize(requireContext()) {
            Log.d("AchievementActivity", "AchievementData : ${TeamMemberData.teamMembers.size}")
            val adapter = ScheduleAdapter()
            binding.recSchedule.adapter = adapter;
            adapter.notifyDataSetChanged()
        }
    }
}
