package com.pemujaandroidstudio.esportcompanyprofileapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import android.widget.TwoLineListItem
import androidx.recyclerview.widget.RecyclerView
import com.pemujaandroidstudio.esportcompanyprofileapp.ScheduleAdapter.ScheduleViewHolder
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.ScheduleCardBinding
import java.time.format.DateTimeFormatter

class TeamAdapter(context: Context, teams: Array<TeamBank>) :
    ArrayAdapter<TeamBank>(context, 0, teams) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val team = getItem(position)
        var listItemView = convertView
        if (listItemView == null){
            listItemView = LayoutInflater.from(context).inflate(R.layout.team_list, parent, false)
        }

        val titleTextView = listItemView!!.findViewById<TextView>(R.id.txtTeamName)
        val subtitleTextView = listItemView!!.findViewById<TextView>(R.id.txtTeamGameName)
        val container = listItemView!!.findViewById<TwoLineListItem>(R.id.teamListContainer)

        container.setOnClickListener{
            val intent = Intent(context, TeamMemberDetails::class.java)
            intent.putExtra("GAME", team?.game)
            intent.putExtra("TEAM", team?.name)
            context.startActivity(intent)
        }

        titleTextView.text = team?.name
        subtitleTextView.text = team?.game

        return listItemView
    }
}