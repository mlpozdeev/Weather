package com.example.weatherapp.presentation.fragments.weather.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DayWeatherItem(
    val date: String,
    val temperature: String,
    val pressure: String
) : Parcelable
