package com.example.mfpa.Ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mfpa.ViewModel.AnimeViewModel
import com.example.mfpa.databinding.FragmentAddDiaryBinding
import com.example.mfpa.databinding.FragmentAnimeDiaryBinding

class AddDiary : Fragment() {
    private val viewModel: AnimeViewModel by viewModels()
   private lateinit var binding: FragmentAddDiaryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddDiaryBinding.inflate(layoutInflater)

        binding.apply {

            add.setOnClickListener{


            }
        }
        return binding.root
    }

}