package com.example.weatherapp.presentation.activities.weather.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.WeatherApp
import com.example.weatherapp.data.network.service.WeatherService
import com.example.weatherapp.data.repository.WeatherRepository
import com.example.wheatherapp.databinding.ActivityWeatherBinding
import com.example.weatherapp.presentation.activities.weather.viewmodel.WeatherViewModel

const val ARG_CITY_ID = "cityId"

class WeatherActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeatherBinding
    private lateinit var viewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cityId = intent.getIntExtra(ARG_CITY_ID, -1)
        if (cityId == -1) {
            throw NoCityIdException("Не получен идентификатор города")
        }

        val weatherService = (application as WeatherApp).retrofit.create(WeatherService::class.java)

        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return WeatherViewModel(cityId, WeatherRepository(weatherService)) as T
            }
        }).get(WeatherViewModel::class.java)

        val adapter = WeatherListAdapter()
        binding.weatherList.adapter = adapter

        viewModel.weatherListLiveData.observe(this) {
            adapter.submitList(it)
            binding.weatherSwipeRefreshLayout.isRefreshing = false
        }

        binding.weatherSwipeRefreshLayout.setOnRefreshListener {
            viewModel.refreshData()
        }
    }

    private class NoCityIdException(message: String) : Exception(message)
}