package com.example.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.movie.R
import com.example.movie.apiinsta.OnItemClickedListener
import com.example.movie.databinding.MovieItemBinding


class MovieAdapter(   private val movies : List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieHolder>(){
    private lateinit var  binding:MovieItemBinding
  private lateinit var mListener: OnItemClickedListener
    class MovieHolder(var binding: MovieItemBinding,listener:OnItemClickedListener) : RecyclerView.ViewHolder(binding.root){
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        init{
            itemView.setOnClickListener {
                listener.onClickedListener(adapterPosition)
            }
        }
        fun bindMovie(movie : Movie){

            binding.movieTitle.text = movie.title
            binding.movieReleaseDate.text = movie.release
            Glide.with(itemView).load(IMAGE_BASE + movie.poster).into(binding.moviePoster)

        }
    }
    fun setItemClickedListener(listener:OnItemClickedListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        var layoutinflater =LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(layoutinflater,R.layout.movie_item,parent,false)
        return MovieHolder(binding,mListener)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bindMovie(movies[position])
    }
}