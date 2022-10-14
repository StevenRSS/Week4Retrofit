package com.uc.week4retrofit.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uc.week4retrofit.R
import com.uc.week4retrofit.model.Result
import com.uc.week4retrofit.databinding.CardNowPlayingBinding
import com.uc.week4retrofit.view.MovieDetails

class NowPlayingAdapter(private val dataSet: ArrayList<Result>) :
        RecyclerView.Adapter<NowPlayingAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = CardNowPlayingBinding.bind(itemView)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.card_now_playing, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.binding.tvReleasedNowPlaying.text = dataSet[position].release_date
        viewHolder.binding.tvTitleNowPlaying.text = dataSet[position].title
        viewHolder.binding.cvNowPlaying.setOnClickListener{
            val myIntent = Intent(it.context, MovieDetails::class.java)
            myIntent.putExtra("movie_id", dataSet[position].id)
            it.context.startActivity(myIntent)
        }
    }
    override fun getItemCount() = dataSet.size

}