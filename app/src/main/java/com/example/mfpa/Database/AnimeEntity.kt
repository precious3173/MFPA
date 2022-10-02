package com.example.mfpa.Database

import android.app.LauncherActivity.ListItem
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "animes")
class AnimeEntity (@PrimaryKey(autoGenerate = true)
                   val id : Int,
                   @ColumnInfo(name = "AnimeImages")
                   val AnimeImage: Int,
                   @ColumnInfo(name = "AnimeName" )
                   val AnimeName: String,

)


