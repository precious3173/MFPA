package com.example.mfpa.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mfpa.Database.AnimeQuoteEntity
import com.example.mfpa.R
import com.example.mfpa.Ui.AnimeQuote
import com.example.mfpa.databinding.DiaryLayoutBinding
import com.example.mfpa.databinding.FragmentAnimeDiaryBinding

class AnimeQuoteAdapter(val context: Context, val animeQuotes: ArrayList<AnimeQuoteEntity>) : RecyclerView.Adapter<AnimeQuoteAdapter.AnimeQuote>() {

    class AnimeQuote(private val binding: DiaryLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(animeQuoteEntity: AnimeQuoteEntity){

            binding.apply {
               character.text = animeQuoteEntity.character
                quotes.text = animeQuoteEntity.quote
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeQuote {
        val binding = DiaryLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AnimeQuote(binding)
    }

    override fun onBindViewHolder(holder: AnimeQuote, position: Int) {
     val currentPosition = animeQuotes[position]
       holder.bind(currentPosition)
    }

    override fun getItemCount(): Int = animeQuotes.size
}