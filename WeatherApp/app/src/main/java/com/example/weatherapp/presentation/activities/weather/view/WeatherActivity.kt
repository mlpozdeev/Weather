package com.example.weatherapp.presentation.activities.weather.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.WeatherApp
import com.example.weatherapp.data.network.service.WeatherService
import com.example.weatherapp.data.repository.WeatherRepository
import com.example.wheatherapp.databinding.ActivityWeatherBinding
import com.example.weatherapp.presentation.activities.weather.viewmodel.WeatherViewModel
import com.example.weatherapp.presentation.fragments.days_weather.DaysWeatherFragment
import com.example.wheatherapp.R

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

        supportFragmentManager.findFragmentById(R.id.days_weather_fragment)!!.arguments = bundleOf(
            DaysWeatherFragment.ARG_CITY_ID to cityId
        )
    }

    private class NoCityIdException(message: String) : Exception(message)

    companion object {
        const val ARG_CITY_ID = "cityId"
    }
}