package com.pemujaandroidstudio.esportcompanyprofileapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.TeamListBinding

class TeamAdapter(context: Context, teams: Array<TeamBank>) :
    ArrayAdapter<TeamBank>(context, 0, teams) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: TeamListBinding

        if (convertView == null) {
            binding = TeamListBinding.inflate(LayoutInflater.from(context), parent, false)
        } else {
            binding = TeamListBinding.bind(convertView)
        }

        val team = getItem(position)

        binding.txtTeamName.text = team?.name
        binding.txtTeamGameName.text = team?.game

        binding.teamListContainer.setOnClickListener {
            val intent = Intent(context, TeamMemberDetails::class.java)
            intent.putExtra("GAME", team?.game)
            intent.putExtra("TEAM", team?.name)
            context.startActivity(intent)
        }

        return binding.root
    }
}
