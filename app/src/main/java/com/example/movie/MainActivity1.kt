package com.example.movie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movie.apiinsta.MovieApiService
import com.example.movie.apiinsta.MovieResponse
import com.example.movie.apiinsta.OnItemClickedListener
import com.example.movie.databinding.ActivityMain1Binding
import com.example.movie.databinding.ActivityMainBinding


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity1 : AppCompatActivity() {
    private lateinit var  binding: ActivityMain1Binding
    private lateinit var  myAdapter : MovieAdapter
    //private lateinit var intent :Intent
    private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main1)

        initRecycler()
        getMovieData { movies : List<Movie> ->
            myAdapter =MovieAdapter(movies)
            binding.rvMoviesList.adapter = myAdapter
            myAdapter.setItemClickedListener(object :OnItemClickedListener{
                override fun onClickedListener(position: Int) {
                   // Toast.makeText(this@MainActivity,"clicked on item at position $position",Toast.LENGTH_SHORT).show()
                  //  Toast.makeText(this@MainActivity, movies[position].poster,Toast.LENGTH_SHORT).show()
                    val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
                    val url = IMAGE_BASE+movies[position].poster
                 val  intent = Intent(this@MainActivity1,MovieActivity2::class.java)
                       .putExtra("poster",movies[position].poster)

                     .putExtra("overview",movies[position].overview)
                       .putExtra("tittle",movies[position].title)
                       .putExtra("date",movies[position].release)
                    startActivity(intent)


                }

            })
        }



    }

    private fun initRecycler() {
        binding.rvMoviesList.layoutManager = LinearLayoutManager(this)
        binding.rvMoviesList.setHasFixedSize(true)
    }

    private fun getMovieData(callback: (List<Movie>) -> Unit){
        val api = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        api.getMovie().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

        })
    }
}