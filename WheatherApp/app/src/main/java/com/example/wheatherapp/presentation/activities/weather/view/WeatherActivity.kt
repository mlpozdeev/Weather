package com.example.wheatherapp.presentation.activities.weather.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wheatherapp.R
import com.example.wheatherapp.databinding.ActivityWeatherBinding
import com.example.wheatherapp.presentation.activities.weather.model.WeatherItem
import java.lang.Exception

const val ARG_CITY_ID = "cityId"

class WeatherActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeatherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cityId = intent.getIntExtra(ARG_CITY_ID, -1)
        if (cityId == -1) {
            throw NoCityIdException("Не получен идентификатор города")
        }

        val adapter = WeatherListAdapter()
        binding.weatherList.adapter = adapter

        adapter.submitList(listOf(
            WeatherItem(
                date = "25.04",
                temperature = "+6"
            )
        ))
    }

    class NoCityIdException(message: String) : Exception(message)
}