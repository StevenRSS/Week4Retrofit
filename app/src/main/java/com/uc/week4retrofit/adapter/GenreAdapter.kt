package com.uc.week4retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uc.week4retrofit.R
import com.uc.week4retrofit.databinding.CardGenreBinding
import com.uc.week4retrofit.model.Genre
import com.uc.week4retrofit.model.MovieDetails

class GenreAdapter(private val dataSet: ArrayList<MovieDetails>):
        RecyclerView.Adapter<GenreAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = CardGenreBinding.bind(itemView)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.card_genre, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.binding.tvGenre.text = dataSet[position].genres.get(position).name
    }

    override fun getItemCount() = dataSet.size

}
