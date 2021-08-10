package com.example.weatherapp.domain.model

import java.util.*

data class DayWeatherData(
    val date: Date,
    val pressure: Int,
    val temperature: String,
    val feel: String,
    val humidity: Int,
    val wind: String,
    val cloud: String
)
