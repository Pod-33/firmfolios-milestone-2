package com.example.groupproject_jose

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CompanyAdapter(private val companyList: MutableList<Company>) : RecyclerView.Adapter<CompanyAdapter.CompanyViewHolder>() {
    private lateinit var context: Context

    class CompanyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val companyNameTextView: TextView = view.findViewById(R.id.compName)
        val descriptionTextView: TextView = view.findViewById(R.id.description)
        val statusTextView: TextView = view.findViewById(R.id.compStatus)
        val countryTextView: TextView = view.findViewById(R.id.country)
        val addressTextView: TextView = view.findViewById(R.id.address)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyAdapter.CompanyViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.company_info_layout, parent, false)
        return CompanyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return companyList.size
    }

    override fun onBindViewHolder(holder: CompanyAdapter.CompanyViewHolder, position: Int) {
        val company = companyList[position]

        holder.companyNameTextView.text = "Company Name: ${company.name}"
        holder.descriptionTextView.text = "Description: ${company.description}"
        holder.statusTextView.text = "Status: ${company.status}"
        holder.countryTextView.text = "Country: ${company.country}"
        holder.addressTextView.text = "Address: ${company.address}"
    }

    // Add this method to update the dataset
    fun setData(newCompanyList: List<Company>) {
        companyList.clear()
        companyList.addAll(newCompanyList)
        notifyDataSetChanged()
    }
}
