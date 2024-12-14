package com.pemujaandroidstudio.esportcompanyprofileapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.ScheduleCardBinding
import java.time.format.DateTimeFormatter

class ScheduleAdapter()
    :RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>(){
    class ScheduleViewHolder(val binding: ScheduleCardBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val binding = ScheduleCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false)
        return ScheduleViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return ScheduleData.schedules.size
    }

    val dateFormatter = DateTimeFormatter.ofPattern("dd")
    val monthFormatter = DateTimeFormatter.ofPattern("MMM")
    val timeFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm a")
    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.binding.txtDate.text = ScheduleData.schedules[position].dateAndTime.format(dateFormatter)
        holder.binding.txtMonth.text = ScheduleData.schedules[position].dateAndTime.format(monthFormatter)
        holder.binding.txtSchedule.text = ScheduleData.schedules[position].title
        holder.binding.txtGame.text = ScheduleData.schedules[position].game + " - "
        holder.binding.txtTeam.text = ScheduleData.schedules[position].team

        holder.binding.card.setOnClickListener {
            val intent = Intent(holder.itemView.context, ScheduleDetailActivity::class.java)
            intent.putExtra("TITLE", ScheduleData.schedules[position].title)
            intent.putExtra("GAME", ScheduleData.schedules[position].game)
            intent.putExtra("TEAM", ScheduleData.schedules[position].team)
            intent.putExtra("DESCRIPTION", ScheduleData.schedules[position].description)
            val timeAndLocation = ScheduleData.schedules[position].location + " (" + ScheduleData.schedules[position].dateAndTime.format(timeFormatter) + " )"
            intent.putExtra("TIME_AND_LOCATION", timeAndLocation)
            intent.putExtra("IMAGE", ScheduleData.schedules[position].image)

            holder.itemView.context.startActivity(intent)

        }

    }
}