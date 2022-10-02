package com.example.mfpa.Database


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AnimeDao {
      @Query( "SELECT * FROM animes " )
       fun getAll(): List<AnimeEntity>

      @Query ("SELECT * FROM animes WHERE AnimeName LIKE '%:query%'")
      fun searchLists(query: String): ArrayList<AnimeEntity>

    @Insert
    fun insert (animeEntity: AnimeEntity)

    @Delete
    fun delete (animeEntity: AnimeEntity)

}