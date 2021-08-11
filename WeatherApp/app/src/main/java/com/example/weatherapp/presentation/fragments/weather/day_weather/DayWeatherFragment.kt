package com.example.weatherapp.presentation.fragments.weather.day_weather

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weatherapp.presentation.fragments.weather.model.DayWeatherItem
import com.example.wheatherapp.databinding.FragmentDayWeatherBinding

class DayWeatherFragment : Fragment() {

    private var _binding: FragmentDayWeatherBinding? = null

    private val binding get() = _binding!!

    private lateinit var weather: DayWeatherItem

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDayWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        weather = requireArguments().getParcelable(ARG_WEATHER_ITEM)!!

        binding.apply {
            dateTextView.text = weather.date
            temperatureTextView.text = weather.temperature
            pressureTextView.text = weather.pressure
        }
    }

    companion object {

        const val ARG_WEATHER_ITEM = "weather"

        fun newInstance(
            weather: DayWeatherItem
        ): DayWeatherFragment {
            return DayWeatherFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_WEATHER_ITEM, weather)
                }
            }
        }
    }
}