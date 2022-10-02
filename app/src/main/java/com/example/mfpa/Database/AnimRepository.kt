package com.example.mfpa.Database

import java.util.Objects


interface AnimRepository {

    fun getAll () : AnimeEntity
    fun add(value: Object)
    fun remove(index: Int)
    fun query(query: String) : AnimeEntity
}