package com.pemujaandroidstudio.esportcompanyprofileapp

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

object TeamData {
var teams: Array<TeamBank> = emptyArray()
    private const val TAG = "TeamData"
    var isInitialized: Boolean = false

    fun initialize(context: Context, onComplete: () -> Unit) {
        val url = "https://ubaya.xyz/native/160422065/teams.php"

        val jsonRequest = JSONObject()

        val request = JsonObjectRequest(
            Request.Method.POST, url, jsonRequest,
            { response ->
                try {
                    if (response.getString("result") == "OK") {
                        val data = response.getJSONArray("data")
                        val fetchedTeams = mutableListOf<TeamBank>()

                        for (i in 0 until data.length()) {
                            val gameObject = data.getJSONObject(i)
                            fetchedTeams.add(
                                TeamBank(
                                    name = gameObject.getString("Team"),
                                    game = gameObject.getString("Game"),
                                    imageLink = gameObject.getString("image")
                                )
                            )
                        }

                        teams = fetchedTeams.toTypedArray()
                        Log.d(TAG, "Teams fetched successfully: ${teams.size}")
                        onComplete()
                    } else {
                        Log.w(TAG, "Failed to fetch teams: ${response.getString("message")}")
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
        isInitialized = true
    }
}