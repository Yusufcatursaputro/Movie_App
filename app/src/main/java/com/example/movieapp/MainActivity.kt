package com.example.movieapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.databinding.ItemMovieBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapterMovie = MovieAdapter(generateDummy()) { movie ->
            val intentToSecondActivity = Intent(this@MainActivity, MovieDetailActivity::class.java)
            intentToSecondActivity.putExtra("EXTRA_NAME", movie.nameMovie)
            startActivity(intentToSecondActivity)
        }

        binding.listMovie.adapter = adapterMovie
    }

    private fun generateDummy(): List<Movie> {
        return listOf(
            Movie(imageMovie = R.drawable.movie_1, genreMovie = "Action", nameMovie = "Venom : The Last Dance", timeMovie = "1h 49m", ratingMovie = "R13+", synopsisMovie = getString(R.string.synopsis_movie_1)),
            Movie(imageMovie = R.drawable.movie_2, genreMovie = "Action", nameMovie = "DOSA MUSYRIK", timeMovie = "1h 32m", ratingMovie = "D17+", synopsisMovie = getString(R.string.synopsis_movie_2)),
            Movie(imageMovie = R.drawable.movie_3, genreMovie = "Action", nameMovie = "Inside Out 2", timeMovie = "1h 36m", ratingMovie = "SU", synopsisMovie = getString(R.string.synopsis_movie_3)),
            Movie(imageMovie = R.drawable.movie_4, genreMovie = "Action", nameMovie = "Transformer One", timeMovie = "1h 44m", ratingMovie = "R13+", synopsisMovie = getString(R.string.synopsis_movie_4)),
            Movie(imageMovie = R.drawable.movie_5, genreMovie = "Action", nameMovie = "Sekawan Limo", timeMovie = "1h 52m", ratingMovie = "R13+", synopsisMovie = getString(R.string.synopsis_movie_5)),
            Movie(imageMovie = R.drawable.movie_6, genreMovie = "Action", nameMovie = "Ancika", timeMovie = "1h 40m", ratingMovie = "R13+", synopsisMovie = getString(R.string.synopsis_movie_6))
        )
    }
}

typealias OnClickMovie = (Movie) -> Unit

class MovieAdapter(
    private val listMovie: List<Movie>,
    private val onClickMovie: OnClickMovie
) : RecyclerView.Adapter<MovieAdapter.ItemMovieViewHolder>() {

    inner class ItemMovieViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Movie) {
            with(binding) {
                imageMovie.setImageResource(data.imageMovie)
                titleMovie.text = data.nameMovie
                timeMovie.text = data.timeMovie
                ratingMovie.text = data.ratingMovie

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, MovieDetailActivity::class.java).apply {
                        putExtra("EXTRA_IMAGE", data.imageMovie)
                        putExtra("EXTRA_NAME", data.nameMovie)
                        putExtra("EXTRA_GENRE", data.genreMovie)
                        putExtra("EXTRA_TIME", data.timeMovie)
                        putExtra("EXTRA_RATING", data.ratingMovie)
                        putExtra("EXTRA_SYNOPSIS", data.synopsisMovie)
                    }
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemMovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemMovieViewHolder(binding)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: ItemMovieViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }
}
