package com.example.weatherapp.presentation.activities.weather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.repository.WeatherRepository
import com.example.weatherapp.presentation.activities.weather.model.WeatherItem
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class WeatherViewModel(
    private val cityId: Int,
    private val repository: WeatherRepository
) : ViewModel() {

    private val mutableWeatherListLiveData: MutableLiveData<List<WeatherItem>> = MutableLiveData()

    val weatherListLiveData: LiveData<List<WeatherItem>> = mutableWeatherListLiveData

    init {
        loadData()
    }

    fun refreshData() {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            mutableWeatherListLiveData.value = repository.getWeatherByCityId(cityId)
                .map {
                    val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.ROOT)
                    WeatherItem(
                        date = dateFormat.format(it.date),
                        temperature = it.temperature
                    )
                }
        }
    }
}