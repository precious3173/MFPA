package com.example.mfpa.Database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "animeQuote")
data class AnimeQuoteEntity(val character : String,
                            val quote: String,
                            @PrimaryKey val id : Int? = null
                            )