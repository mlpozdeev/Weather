package com.example.weatherapp.presentation.fragments.weather.days_weather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.repository.WeatherRepository
import com.example.weatherapp.presentation.fragments.weather.model.DayWeatherItem
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class DaysWeatherViewModel(
    private val cityId: Int,
    private val repository: WeatherRepository
) : ViewModel() {

    private val mutableWeatherListLiveData: MutableLiveData<List<DayWeatherItem>> = MutableLiveData()

    val weatherListLiveData: LiveData<List<DayWeatherItem>> = mutableWeatherListLiveData

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
                    DayWeatherItem(
                        date = dateFormat.format(it.date),
                        temperature = it.temperature
                    )
                }
        }
    }
}