package com.example.weatherapp.presentation.fragments.weather.days_weather.view

import com.example.weatherapp.presentation.fragments.weather.model.DayWeatherItem

interface DaysFragmentCallback {
    fun onDaysFragmentCallback(item: DayWeatherItem)
}