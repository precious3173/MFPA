package com.example.mfpa

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert

@Dao
interface AnimeDao {


    @Insert
    fun insert (animeEntity: AnimeEntity)

    @Delete
    fun delete (animeEntity: AnimeEntity)

}