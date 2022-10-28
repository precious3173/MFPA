package com.example.mfpa.Ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.mfpa.Database.AnimeQuoteEntity
import com.example.mfpa.R
import com.example.mfpa.ViewModel.AddQuoteViewModel
import com.example.mfpa.ViewModel.AnimeViewModel
import com.example.mfpa.databinding.FragmentAddDiaryBinding
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



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            val charact= character

            var quot = quote


            add.setOnClickListener{
                if(quot != null && charact!=null){
                val characters : String =charact.text.toString()
                val quotes : String = quot.text.toString()
                addDetails(characters, quotes)
                    findNavController().navigate(R.id.action_addDiary_to_animeDiary)
                }
                else Toast.makeText(context, "Field is empty", Toast.LENGTH_SHORT).show()

            }
        }

    }

    private fun addDetails(characters: String, quotes: String) {

        viewModel.addNewQuote( AnimeQuoteEntity(character = characters, quote = quotes))
    }

}