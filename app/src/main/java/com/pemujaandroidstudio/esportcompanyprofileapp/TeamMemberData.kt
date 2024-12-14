package com.pemujaandroidstudio.esportcompanyprofileapp

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.pemujaandroidstudio.esportcompanyprofileapp.TeamData.teams
import org.json.JSONObject

object TeamMemberData {
    var teamMembers: Array<TeamMemberBank> = emptyArray()
    private const val TAG = "TeamMemberData"

    fun initialize(context: Context, onComplete: () -> Unit) {
        val url = "https://ubaya.xyz/native/160422065/get_members.php"

        val jsonRequest = JSONObject()

        val request = JsonObjectRequest(
            Request.Method.POST, url, jsonRequest,
            { response ->
                try {
                    if (response.getString("result") == "OK") {
                        val data = response.getJSONArray("data")
                        val fetchedTeams = mutableListOf<TeamMemberBank>()

                        for (i in 0 until data.length()) {
                            val gameObject = data.getJSONObject(i)
                            fetchedTeams.add(
                                TeamMemberBank(
                                    name = gameObject.getString("username"),
                                    team = gameObject.getString("Team"),
                                    game = gameObject.getString("Game"),
                                    imagelink = gameObject.getString("image"),
                                    role = gameObject.getString("role")
                                )
                            )
                        }

                        teamMembers = fetchedTeams.toTypedArray()
                        Log.d(TAG, "Team Members fetched successfully: ${teams.size}")
                        onComplete()
                    } else {
                        Log.w(TAG, "Failed to fetch team members: ${response.getString("message")}")
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "Error parsing response: ${e.message}")
                }
            },
            { error ->
                Log.e(TAG, "Error fetching data: ${error.message}")
            }
        )
        Volley.newRequestQueue(context).add(request)
    }
}