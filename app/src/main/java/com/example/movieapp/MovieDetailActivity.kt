package com.example.movieapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.ItemMovieBinding
import com.example.movieapp.databinding.MovieDetailBinding

class MovieDetailActivity : AppCompatActivity() {
    private lateinit var binding: MovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageMovie = intent.getIntExtra("EXTRA_IMAGE", 0)
        val nameMovie = intent.getStringExtra("EXTRA_NAME")
        val genreMovie = intent.getStringExtra("EXTRA_GENRE")
        val timeMovie = intent.getStringExtra("EXTRA_TIME")
        val ratingMovie = intent.getStringExtra("EXTRA_RATING")
        val synopsisMovie = intent.getStringExtra("EXTRA_SYNOPSIS")

        binding.imageMovie.setImageResource(imageMovie)
        binding.titleMovie.text = nameMovie
        binding.genreMovie.text = genreMovie
        binding.timeMovie.text = timeMovie
        binding.ratingMovie.text = ratingMovie
        binding.synopsisMovie.text = synopsisMovie
    }

}

