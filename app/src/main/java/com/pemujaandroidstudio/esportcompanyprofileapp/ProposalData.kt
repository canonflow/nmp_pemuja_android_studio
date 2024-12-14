package com.pemujaandroidstudio.esportcompanyprofileapp

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

object ProposalData {
    var proposals: Array<ProposalBank> = emptyArray()
    private const val TAG = "ProposalData"

    fun initialize(context: Context, username: String, onComplete: () -> Unit) {
        val url = "https://ubaya.xyz/native/160422065/proposals.php"

        val stringRequest = object : StringRequest(
            Request.Method.POST,
            url,
            { response ->
                try {
                    // Attempt to parse as JSON
                    val obj = JSONObject(response)
                    if (obj.getString("result") == "OK") {
                        val data = obj.getJSONArray("data")
                        val fetchedProposal = mutableListOf<ProposalBank>()

                        for (i in 0 until data.length()) {
                            val gameObject = data.getJSONObject(i)
                            fetchedProposal.add(
                                ProposalBank(
                                    status = gameObject.getString("status"),
                                    team = gameObject.getString("Team"),
                                    member = gameObject.getString("Member"),
                                    game = gameObject.getString("Game"),
                                    description = gameObject.getString("description"),
                                )
                            )
                        }

                        proposals = fetchedProposal.toTypedArray()
                        Log.d(TAG, "Proposals fetched successfully: ${proposals.size}")
                        onComplete()
                    } else {
                        Log.w(TAG, "Failed to fetch proposals: ${obj.getString("message")}")
                    }
                } catch (e: Exception) {
                    // Log the full response for debugging
                    Log.e(TAG, "Non-JSON response received: $response")
                }
            },
            { error ->
                Log.e(TAG, "Error fetching data: ${error.message}")
            }
        ) {
            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String, String>()
                params["username"] = username
                return params
            }
        }

        Volley.newRequestQueue(context).add(stringRequest)
    }
}
