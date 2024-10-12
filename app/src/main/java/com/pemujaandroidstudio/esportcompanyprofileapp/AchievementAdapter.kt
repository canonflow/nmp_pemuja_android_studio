package com.pemujaandroidstudio.esportcompanyprofileapp
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import java.time.format.DateTimeFormatter

class AchievementAdapter(context: Context, achievements: Array<AchievementBank>) :
    ArrayAdapter<AchievementBank>(context, 0, achievements) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get the data item for this position
        val achievement = getItem(position)
        // Check if an existing view is being reused, otherwise inflate the view
        var listItemView = convertView
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2, parent, false)
        }

        // Find TextViews in the layout (simple_list_item_2 contains two TextViews: one for the title and one for the subtitle)
        val titleTextView = listItemView!!.findViewById<TextView>(android.R.id.text1)
        val subtitleTextView = listItemView.findViewById<TextView>(android.R.id.text2)

        // Set the achievement and the date
        titleTextView.text = achievement?.achievement
        subtitleTextView.text = "Team: ${achievement?.team} | Date: ${achievement?.time?.format(DateTimeFormatter.ofPattern("yyyy"))}"

        return listItemView
    }
}
