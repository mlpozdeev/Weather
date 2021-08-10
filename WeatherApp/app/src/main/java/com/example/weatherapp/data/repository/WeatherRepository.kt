package com.example.weatherapp.data.repository

import com.example.weatherapp.data.network.service.WeatherService
import com.example.weatherapp.domain.model.DayWeatherData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherRepository(private val service: WeatherService) {

    suspend fun getWeatherByCityId(cityId: Int): List<DayWeatherData> =
        withContext(Dispatchers.IO) {
            return@withContext service.getWeatherByCity(cityId)
                .filter {
                    it.tod == 0
                }
                .map {
                    DayWeatherData(
                        date = it.date,
                        pressure = it.pressure,
                        temperature = it.temp.replace("&minus;", "-"),
                        feel = it.feel,
                        humidity = it.humidity,
                        wind = it.wind,
                        cloud = it.cloud
                    )
                }
        }
}