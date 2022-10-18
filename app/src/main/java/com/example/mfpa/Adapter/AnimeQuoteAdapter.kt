package com.example.mfpa.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mfpa.Database.AnimeQuoteEntity
import com.example.mfpa.R
import com.example.mfpa.Ui.AnimeQuote
import com.example.mfpa.databinding.DiaryLayoutBinding
import com.example.mfpa.databinding.FragmentAnimeDiaryBinding
import javax.inject.Inject

class AnimeQuoteAdapter @Inject constructor() : RecyclerView.Adapter<AnimeQuoteAdapter.AnimeQuote>() {

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
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size

  private val differCallback = object:
  DiffUtil.ItemCallback<AnimeQuoteEntity>(){
      override fun areItemsTheSame(oldItem: AnimeQuoteEntity, newItem: AnimeQuoteEntity): Boolean {
          return oldItem.id == newItem.id
      }

      override fun areContentsTheSame(
          oldItem: AnimeQuoteEntity,
          newItem: AnimeQuoteEntity
      ): Boolean {
          return  oldItem == newItem
      }

  }

    val differ = AsyncListDiffer(this, differCallback)
}