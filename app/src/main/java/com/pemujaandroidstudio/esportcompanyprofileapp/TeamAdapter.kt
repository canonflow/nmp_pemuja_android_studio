package com.pemujaandroidstudio.esportcompanyprofileapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
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
            listItemView = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2, parent, false)
        }

        val titleTextView = listItemView!!.findViewById<TextView>(android.R.id.text1)
//        val subtitleTextView = listItemView.findViewById<TextView>(android.R.id.text2)
//
//        titleTextView.text = team?.name
//        subtitleTextView.text = "Team: ${achievement?.team} | Date: ${achievement?.time?.format(
//            DateTimeFormatter.ofPattern("yyyy"))}"

        return listItemView
    }
}