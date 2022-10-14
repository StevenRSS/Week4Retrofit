package com.uc.week4retrofit.adapter

import android.graphics.Movie
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uc.week4retrofit.R
import com.uc.week4retrofit.databinding.CardCompanyLogoBinding
import com.uc.week4retrofit.helper.Const
import com.uc.week4retrofit.model.ProductionCompany
import com.uc.week4retrofit.view.MovieDetails

class CompanyLogoAdapter(private val dataSet: ArrayList<com.uc.week4retrofit.model.MovieDetails>) :
    RecyclerView.Adapter<CompanyLogoAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = CardCompanyLogoBinding.bind(itemView)


    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_company_logo, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Glide.with(viewHolder.itemView)
            .load(Const.IMG_URL + dataSet[position].production_companies.get(position).logo_path)
            .into(viewHolder.binding.companyLogo)
    }

    override fun getItemCount() = dataSet.size

}
