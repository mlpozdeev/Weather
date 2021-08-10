package com.example.weatherapp.data.network.service

import com.example.weatherapp.data.network.dto.DayWeatherDataDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherService {
    @GET("meteo.php")
    suspend fun getWeatherByCity(@Query("tid") cityId: Int): List<DayWeatherDataDTO>
}