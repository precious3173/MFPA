package com.example.mfpa.Ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mfpa.R
import com.example.mfpa.ViewModel.AnimeViewModel
import com.example.mfpa.databinding.FragmentAnimeDiaryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeQuote : Fragment() {

    private val viewModel: AnimeViewModel by viewModels()
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

       binding.search.addTextChangedListener(object: TextWatcher{
           override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
               TODO("Not yet implemented")
           }

           override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
               val search  = p0.toString()

           }

           override fun afterTextChanged(p0: Editable?) {
               TODO("Not yet implemented")
           }

       }

       )
    }
}