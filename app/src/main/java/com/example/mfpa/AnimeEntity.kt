package com.example.mfpa

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity (tableName = "animes")
class AnimeEntity (@PrimaryKey (autoGenerate = true)
                   val id : Int,

                   @ColumnInfo(name = "AnimeImages")
                   val AnimeImage: Int,
                   @ColumnInfo(name = "AnimeName" )
                   val AnimeName: String

) {


}