package com.example.groupproject_jose

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import androidx.recyclerview.widget.LinearLayoutManager
import org.json.JSONObject
import java.net.URLEncoder

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var companyNameEditText: EditText
    private lateinit var countryEditText: EditText
    private lateinit var searchButton: Button
    private lateinit var companyAdapter: CompanyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycleView_layout)
        companyNameEditText = findViewById(R.id.companyNameEditText)
        countryEditText = findViewById(R.id.countryEditText)
        searchButton = findViewById(R.id.searchButton)
//        compNameTextView = findViewById(R.id.compName)
//        descriptionTextView = findViewById(R.id.description)

        // Create a CompanyAdapter and set it to the RecyclerView
        companyAdapter = CompanyAdapter(mutableListOf())
        recyclerView.adapter = companyAdapter

        // Set a LinearLayoutManager to the RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        searchButton.setOnClickListener {
            val companyName = companyNameEditText.text.toString()
            val country = countryEditText.text.toString()
            apiInfo(companyName, country)
        }
    }

    private fun apiInfo(companyName: String, country: String) {
        val client = AsyncHttpClient()
        val apiKey = "c66c5dad-395c-4ec6-afdf-7b78eb94166a"
        val baseUrl = "https://api.orb-intelligence.com/3/match/"

        val urlParams = mapOf(
            "name" to companyName,
            "country" to country,
            "api_key" to apiKey
        )

        val apiUrl = buildUrl(baseUrl, urlParams)

        client.get(apiUrl, object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JsonHttpResponseHandler.JSON) {
                Log.d("API", "Response successful")
                Log.d("API", "Data: $json ")

                val jsonObject = json.jsonObject
                if (jsonObject != null) {
                    val companies = parseCompanies(jsonObject)
                    updateRecyclerView(companies)
                } else {
                    Log.e("API Error", "Failed to parse JSON response")
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                errorResponse: String,
                throwable: Throwable?
            ) {
                Log.d("API Error", "Status Code: $statusCode, Error Response: $errorResponse")
            }
        })
    }

    private fun parseCompanies(jsonObject: JSONObject): List<Company> {
        val companies = mutableListOf<Company>()
        val resultsArray = jsonObject.optJSONArray("results")

        resultsArray?.let {
            for (i in 0 until it.length()) {
                val companyObject = it.optJSONObject(i)
                val company = Company(
                    name = companyObject.optString("name", ""),
                    description = companyObject.optString("description", ""),
                    status = companyObject.optString("company_status", ""),
                    country = companyObject.optString("country", ""),
                    address = companyObject.optJSONObject("address")?.optString("address1", "") ?: ""
                )
                companies.add(company)
            }
        }

        return companies
    }

    private fun updateRecyclerView(companies: List<Company>) {
        companyAdapter.setData(companies)
    }

    private fun buildUrl(baseUrl: String, params: Map<String, String>): String {
        val queryString = params.entries.joinToString("&") { (key, value) ->
            "$key=${value.encodeUrl()}"
        }
        return if (queryString.isNotEmpty()) {
            "$baseUrl?$queryString"
        } else {
            baseUrl
        }
    }

    private fun String.encodeUrl(): String {
        return URLEncoder.encode(this, "UTF-8")
    }
}
