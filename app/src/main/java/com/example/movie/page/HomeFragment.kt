package com.example.movie.page

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.movie.MainActivity1

import com.example.movie.R
import com.example.movie.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        navi()
        return binding.root
    }

private fun navi(){

    Handler(Looper.getMainLooper()).postDelayed({
    val intent = Intent(activity,MainActivity1::class.java)
        startActivity(intent)
    },1000)
}
}