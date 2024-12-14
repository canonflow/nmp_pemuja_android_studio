package com.pemujaandroidstudio.esportcompanyprofileapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.GameCardBinding
import com.squareup.picasso.Picasso

class GameAdapter : RecyclerView.Adapter<GameAdapter.GameViewHolder>(){
    class GameViewHolder(val binding: GameCardBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        var binding = GameCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return GameViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return GameData.games.size
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.binding.txtGame.text = GameData.games[position].name
        holder.binding.txtGameDescription.text = GameData.games[position].description
        Picasso.get()
            .load(GameData.games[position].imageLink)
            .into(holder.binding.banner)

        holder.binding.btnAchievement.setOnClickListener {
            val intent = Intent(holder.itemView.context, AchievementDetails::class.java)
            intent.putExtra("GAME", GameData.games[position].name)
            intent.putExtra("IMAGE", GameData.games[position].imageLink)

            holder.itemView.context.startActivity(intent)
        }

        holder.binding.btnTeams.setOnClickListener {
            val intent = Intent(holder.itemView.context, TeamActivity::class.java)
            intent.putExtra("GAME", GameData.games[position].name)
            intent.putExtra("IMAGE", GameData.games[position].imageLink)

            holder.itemView.context.startActivity(intent)
        }
    }
}