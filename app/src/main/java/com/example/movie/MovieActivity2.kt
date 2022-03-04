package com.example.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.movie.databinding.ActivityMovie2Binding

class MovieActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMovie2Binding
    private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_movie2)
        val bundle:Bundle? =intent.extras
        binding.date.text = bundle?.getString("date")
        binding.titleMovie.text= bundle?.getString("tittle")
        binding.overview.text =bundle?.getString("overview")
        val post = bundle!!.getString("poster")
        val  url = IMAGE_BASE+post

        Glide.with(this).load(url).into(binding.image)

    }

}