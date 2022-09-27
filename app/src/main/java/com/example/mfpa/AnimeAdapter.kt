package com.example.mfpa

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class AnimeAdapter(val context: Context, val animeList: ArrayList<HomeData>) : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>(),
    View.OnClickListener {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.anime_layout, parent, false)

        return AnimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {

        val anime = animeList[position]
        holder.add(anime, position)
        holder.click()
    }

    override fun getItemCount(): Int = animeList.size

    inner class AnimeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {


        private var positions: Int = -1
        private var animes: HomeData? = null

        private val characterNames = itemView.findViewById<TextView>(R.id.characterNames)
        private val characterImage = itemView.findViewById<ImageView>(R.id.characterImages)


        fun add(anime: HomeData, position: Int){

            characterNames.text = anime.characterName
            characterImage.setImageResource(anime.characterImage)

            this.positions = position
            this.animes = anime
        }

        fun click(){

            characterImage.setOnClickListener(this@AnimeAdapter)
        }

        override fun onClick(p0: View?) {
           Toast.makeText(context, characterNames.text, Toast.LENGTH_SHORT).show()
          }

    }

    override fun onClick(p0: View?) {

    }


}