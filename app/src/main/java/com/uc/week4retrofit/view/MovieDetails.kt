package com.uc.week4retrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.uc.week4retrofit.adapter.CompanyLogoAdapter
import com.uc.week4retrofit.adapter.GenreAdapter
import com.uc.week4retrofit.databinding.ActivityMovieDetailsBinding
import com.uc.week4retrofit.helper.Const
import com.uc.week4retrofit.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetails : AppCompatActivity() {

    private lateinit var viewBind: ActivityMovieDetailsBinding
    private lateinit var adapterGenre: GenreAdapter
    private lateinit var adapterCL: CompanyLogoAdapter
    private lateinit var viewModel: MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBind = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(viewBind.root)

        val movieID = intent.getIntExtra("movie_id", 0)
        Toast.makeText(applicationContext, "Movie ID : ${movieID}", Toast.LENGTH_SHORT).show()

        viewModel = ViewModelProvider(this)[MoviesViewModel::class.java]
        viewModel.getMovieDetails(Const.API_KEY, movieID)
        viewModel.movieDetail.observe(this, Observer{ response ->
            viewBind.tvTitleMovieDetails.apply {
                text = response.title
            }
            viewBind.rvGenre.layoutManager = LinearLayoutManager(this)
            adapterGenre = GenreAdapter(arrayListOf(response))
            viewBind.rvGenre.adapter = adapterGenre

            viewBind.rvCompanyLogo.layoutManager = LinearLayoutManager(this)
            adapterCL = CompanyLogoAdapter(arrayListOf(response))
            viewBind.rvCompanyLogo.adapter = adapterCL

            viewBind.descMovieDetails.apply {
                text = response.overview
            }


            Glide.with(applicationContext)
                .load(Const.IMG_URL + response.backdrop_path)
                .into(viewBind.imgMoviedetails)
        })

    }
}