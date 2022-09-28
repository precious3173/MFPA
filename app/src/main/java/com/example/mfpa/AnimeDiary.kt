package com.example.mfpa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mfpa.databinding.FragmentAnimeDiaryBinding
import com.example.mfpa.databinding.FragmentHomeScreenBinding


class AnimeDiary : Fragment() {

   private lateinit var binding: FragmentAnimeDiaryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnimeDiaryBinding.inflate(layoutInflater)

        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       binding.addDiary.setOnClickListener {

           findNavController().navigate(R.id.action_animeDiary_to_addDiary)
       }
    }
}