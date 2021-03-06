package com.example.weatherapp.presentation.activities.weather.view

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.example.weatherapp.presentation.fragments.weather.day_weather.DayWeatherFragment
import com.example.weatherapp.presentation.fragments.weather.days_weather.view.DaysFragmentCallback
import com.example.wheatherapp.databinding.ActivityWeatherBinding
import com.example.weatherapp.presentation.fragments.weather.days_weather.view.DaysWeatherFragment
import com.example.weatherapp.presentation.fragments.weather.model.DayWeatherItem
import com.example.wheatherapp.R

class WeatherActivity : AppCompatActivity(), DaysFragmentCallback {

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

    override fun onDaysFragmentCallback(item: DayWeatherItem) {
        val dayFragment = DayWeatherFragment.newInstance(item)
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.days_weather_fragment, dayFragment)
                .addToBackStack(null)
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.day_weather_fragment, dayFragment)
                .addToBackStack(null)
                .commit()
        }
    }

    private class NoCityIdException(message: String) : Exception(message)

    companion object {
        const val ARG_CITY_ID = "cityId"
    }
}