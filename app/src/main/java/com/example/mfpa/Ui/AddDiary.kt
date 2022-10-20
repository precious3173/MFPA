package com.example.mfpa.Ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.mfpa.Database.AnimeQuoteEntity
import com.example.mfpa.ViewModel.AddQuoteViewModel
import com.example.mfpa.ViewModel.AnimeViewModel
import com.example.mfpa.databinding.FragmentAddDiaryBinding
import com.example.mfpa.databinding.FragmentAnimeDiaryBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import kotlin.collections.ArrayList


@AndroidEntryPoint
class AddDiary : Fragment() {
    private val viewModel: AddQuoteViewModel by viewModels()
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

           var characters= character.text.toString()
            var quotes = quote.text.toString()
            add.setOnClickListener{

                val animeQuoteEntity = AnimeQuoteEntity(characters,quotes)
                viewModel.addNewQuote(animeQuoteEntity)
            }
        }
        return binding.root
    }

}