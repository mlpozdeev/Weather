package com.example.weatherapp.data.network.dto

import java.util.*

data class DayWeatherDataDTO(
    val date: Date,
    val tod: Int,
    val pressure: Int,
    val temp: String,
    val feel: String,
    val humidity: Int,
    val wind: String,
    val cloud: String,
    val tid: Int
)
