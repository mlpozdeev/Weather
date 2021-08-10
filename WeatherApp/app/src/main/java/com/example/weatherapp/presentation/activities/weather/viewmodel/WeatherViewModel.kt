package com.example.weatherapp.presentation.activities.weather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.presentation.activities.weather.model.WeatherItem

class WeatherViewModel(
    private val cityId: Int
) : ViewModel() {

    private val mutableWeatherListLiveData: MutableLiveData<List<WeatherItem>> = MutableLiveData()

    val weatherListLiveData: LiveData<List<WeatherItem>> = mutableWeatherListLiveData

    init {
        load()
    }

    private fun load() {
        mutableWeatherListLiveData.value = listOf(
            WeatherItem(
                date = "25.04",
                temperature = "+6"
            )
        )
    }
}