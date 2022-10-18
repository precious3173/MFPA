package com.example.mfpa.Database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "animeQuote")
data class AnimeQuoteEntity(@ColumnInfo(name="Character")val character : String,
                            @ColumnInfo(name="Quote") val quote: String,
                            @PrimaryKey (autoGenerate = true) val id : Int = 0
                            ): Parcelable
