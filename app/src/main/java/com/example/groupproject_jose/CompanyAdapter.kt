package com.example.groupproject_jose

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CompanyAdapter(private val companyList: MutableList<Company>) : RecyclerView.Adapter<CompanyAdapter.CompanyViewHolder>() {
    private lateinit var context: Context
    class CompanyViewHolder(view: View) : RecyclerView.ViewHolder(view){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyAdapter.CompanyViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.company_info_layout,parent, false)
        return CompanyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return companyList.size
    }

    override fun onBindViewHolder(holder: CompanyAdapter.CompanyViewHolder, position: Int) {


    }
}