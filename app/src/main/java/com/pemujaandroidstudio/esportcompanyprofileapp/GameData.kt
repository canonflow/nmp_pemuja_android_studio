package com.pemujaandroidstudio.esportcompanyprofileapp

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

object GameData {
    var games: Array<GameBank> = emptyArray()
    private const val TAG = "GameData"
    var isInitialized: Boolean = false

    fun initialize(context: Context, onComplete: () -> Unit) {
        val url = "https://ubaya.xyz/native/160422065/game.php"

        val jsonRequest = JSONObject()

        val request = JsonObjectRequest(
            Request.Method.POST, url, jsonRequest,
            { response ->
                try {
                    if (response.getString("result") == "OK") {
                        val data = response.getJSONArray("data")
                        val fetchedGames = mutableListOf<GameBank>()

                        for (i in 0 until data.length()) {
                            val gameObject = data.getJSONObject(i)
                            fetchedGames.add(
                                GameBank(
                                    name = gameObject.getString("name"),
                                    description = gameObject.getString("description"),
                                    imageLink = gameObject.getString("image")
                                )
                            )
                        }

                        games = fetchedGames.toTypedArray()
                        Log.d(TAG, "Games fetched successfully: ${games.size}")
                        onComplete()
                    } else {
                        Log.w(TAG, "Failed to fetch games: ${response.getString("message")}")
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
