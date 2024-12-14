package com.pemujaandroidstudio.esportcompanyprofileapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.pemujaandroidstudio.esportcompanyprofileapp.R
import com.squareup.picasso.Picasso

class TeamMemberAdapter(context: Context, private val teamMembers: Array<TeamMemberBank>) :
    ArrayAdapter<TeamMemberBank>(context, 0, teamMembers) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItemView = convertView
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.team_member_card, parent, false)
        }

        val currentMember = teamMembers[position]

        val nameTextView = listItemView?.findViewById<TextView>(R.id.member_name)
        nameTextView?.text = currentMember.name

        val roleTextView = listItemView?.findViewById<TextView>(R.id.member_role)
        roleTextView?.text = currentMember.role

        val imageView = listItemView!!.findViewById<ImageView>(R.id.member_image)

        Glide.with(context)
            .load(currentMember.imagelink)
            .apply(
                RequestOptions.circleCropTransform()
                    .placeholder(R.drawable.maskot)
                    .error(R.drawable.maskot)
            )
            .into(imageView)

        return listItemView!!
    }
}
