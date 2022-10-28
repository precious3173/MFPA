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
import com.example.mfpa.Adapter.AnimeQuoteAdapter
import com.example.mfpa.Database.AnimeQuoteEntity
import com.example.mfpa.R
import com.example.mfpa.ViewModel.AddQuoteViewModel
//import com.example.mfpa.databinding.FragmentAnimeDiaryBinding
import com.example.mfpa.databinding.FragmentAnimeQuoteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeQuote : Fragment() {

    private val viewModel: AddQuoteViewModel by viewModels()

//    @Inject
//    lateinit var animeQuoteEntity: AnimeQuoteEntity


   private lateinit var binding: FragmentAnimeQuoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnimeQuoteBinding.inflate(layoutInflater)

        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val animeQuoteAdapter = AnimeQuoteAdapter()
        viewModel.getQuotes()
        val animeQuoteEntity: MutableList<AnimeQuoteEntity> = mutableListOf()


        binding.addDiary.setOnClickListener {

            findNavController().navigate(R.id.action_animeDiary_to_addDiary)
        }





        binding.apply {

            diaryRecyclerview.apply {

                adapter = animeQuoteAdapter
                setHasFixedSize(true)

                animeQuoteAdapter.differ.submitList(animeQuoteEntity)
            }

        }


    }


}