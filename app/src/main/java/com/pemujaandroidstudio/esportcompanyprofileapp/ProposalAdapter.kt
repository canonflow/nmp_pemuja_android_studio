package com.pemujaandroidstudio.esportcompanyprofileapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.ProposalCardBinding

class ProposalAdapter(): RecyclerView.Adapter<ProposalAdapter.ProposalViewHolder>()  {
    class ProposalViewHolder(val binding:
                             ProposalCardBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProposalViewHolder {
        val binding = ProposalCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false)
        return ProposalViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return ProposalData.proposals.size
    }

    override fun onBindViewHolder(holder: ProposalViewHolder, position: Int) {
        holder.binding.txtNameProposal.text=ProposalData.proposals[position].team
        holder.binding.txtStatusProposal.text=ProposalData.proposals[position].status
    }

}