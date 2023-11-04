package com.example.groupproject_jose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apiInfo()


        recyclerView = findViewById(R.id.recycleView_layout)
    }




    private fun apiInfo(){

        val client = AsyncHttpClient()
        val apiKey = "c66c5dad-395c-4ec6-afdf-7b78eb94166a"
        val limit = 10

        client.get("https://api.orb-intelligence.com/3/search/?api_key=$apiKey&limit=$limit", object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JsonHttpResponseHandler.JSON) {
                Log.d("API", "Response successful")
                Log.d("API", "Data: $json ")


                val dataObject = json.jsonObject
                val resultsArray = dataObject.getJSONArray("results")

                val compList = mutableListOf<Company>()

                for (i in 0 until resultsArray.length()) {
                    val companyObject = resultsArray.getJSONObject(i)
                    val name = companyObject.getString("name")
                    val country = companyObject.getString("country")
                    val status = companyObject.getString("company_status")
                    val address = companyObject.optString("address1", "")
                    Log.d("API", "Parsed data - Name: $name, Country: $country, Status: $status, Address: $address")


                    val company = Company(name,address,"none", status, country)
                    compList.add(company)
                }

                Log.d("API", "Starting the loop")
                for (company in compList) {
                    Log.d("API", "Inside the loop")
                    Log.d("API", "Name: ${company.compName}, Country: ${company.country}, Status: ${company.compStatus}, Description: ${company.description}, Address: ${company.address}")
                }
                Log.d("API", "Number of companies in compList: ${compList.size}")
                Log.d("API", "End of the loop")




            }


            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                errorResponse: String,
                throwable: Throwable?
            ) {
                Log.d("API Error", errorResponse)
                // Handle the error response here
            }
        })
    }



}

