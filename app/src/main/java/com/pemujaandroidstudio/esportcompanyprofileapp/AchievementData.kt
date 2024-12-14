package com.pemujaandroidstudio.esportcompanyprofileapp

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.pemujaandroidstudio.esportcompanyprofileapp.TeamData.teams
import org.json.JSONObject
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object AchievementData {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    var achievements: Array<AchievementBank> = emptyArray()
    private const val TAG = "AchievementData"

    fun initialize(context: Context, onComplete: () -> Unit) {
        val url = "https://ubaya.xyz/native/160422065/achievements.php"

        val jsonRequest = JSONObject()

        val request = JsonObjectRequest(
            Request.Method.POST, url, jsonRequest,
            { response ->
                try {
                    if (response.getString("result") == "OK") {
                        val data = response.getJSONArray("data")
                        val fetchedAchievement = mutableListOf<AchievementBank>()

                        for (i in 0 until data.length()) {
                            val gameObject = data.getJSONObject(i)
                            fetchedAchievement.add(
                                AchievementBank(
                                    achievement = gameObject.getString("name"),
                                    team = gameObject.getString("Team"),
                                    game = gameObject.getString("Game"),
                                    time = LocalDateTime.parse(gameObject.getString("date"), formatter)
                                )
                            )
                        }

                        achievements = fetchedAchievement.toTypedArray()
                        Log.d(TAG, "Achievements fetched successfully: ${achievements.size}")
                        onComplete()
                    } else {
                        Log.w(TAG, "Failed to fetch achievement: ${response.getString("message")}")
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