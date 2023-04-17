package com.example.mobileapps1

import kotlin.random.Random

data class Movie(
    val title: String,
    val genre: String,
    val duration: String,
    val rating: String,
    val director: String,
    val cast: List<String>,
    val synopsis: String,
    var seatsRemaining: Int,
    var seatsSelected: Int,
    val imageUrl: String
)

