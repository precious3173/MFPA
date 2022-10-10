package com.example.mfpa.Ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mfpa.databinding.FragmentMyFavouriteBinding


class MyFavourite : Fragment() {

     private lateinit var binding: FragmentMyFavouriteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentMyFavouriteBinding.inflate(layoutInflater)

        return binding.root
    }


}