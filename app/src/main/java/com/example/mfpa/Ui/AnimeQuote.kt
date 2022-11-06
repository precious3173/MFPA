package com.example.mfpa.Ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.findNavController
import com.example.mfpa.Adapter.AnimeQuoteAdapter
import com.example.mfpa.Database.AnimeQuoteEntity
import com.example.mfpa.HomeData
import com.example.mfpa.R
import com.example.mfpa.ViewModel.AddQuoteViewModel
//import com.example.mfpa.databinding.FragmentAnimeDiaryBinding
import com.example.mfpa.databinding.FragmentAnimeQuoteBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeQuote : Fragment() {

    private val addQuoteViewModel: AddQuoteViewModel by viewModels()

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




        var animeQuoteEntity: MutableList<AnimeQuoteEntity> = mutableListOf()

        lifecycle.coroutineScope.launch() {
            addQuoteViewModel.getQuotes().collect{

                val animeQuoteAdapter = AnimeQuoteAdapter()
                animeQuoteAdapter.differ.submitList(it)

                binding.diaryRecyclerview.apply {

                    adapter = animeQuoteAdapter
                    setHasFixedSize(true)

                }
               // animeQuoteEntity = it as MutableList<AnimeQuoteEntity>
            }
        }




        binding.addDiary.setOnClickListener {

            findNavController().navigate(R.id.action_animeDiary_to_addDiary)
        }










    }


}