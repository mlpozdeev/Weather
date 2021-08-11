package com.example.weatherapp.presentation.fragments.weather.days_weather.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.WeatherApp
import com.example.weatherapp.data.network.service.WeatherService
import com.example.weatherapp.data.repository.WeatherRepository
import com.example.weatherapp.presentation.fragments.weather.days_weather.viewmodel.DaysWeatherViewModel
import com.example.wheatherapp.databinding.FragmentDaysWeatherBinding

class DaysWeatherFragment : Fragment() {

    private var _binding: FragmentDaysWeatherBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: DaysWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDaysWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cityId = requireArguments().getInt(ARG_CITY_ID, -1)
        if (cityId == -1) {
            throw NoCityIdException("Не получен идентификатор города")
        }

        val weatherService = (requireActivity().application as WeatherApp).retrofit
            .create(WeatherService::class.java)

        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return DaysWeatherViewModel(cityId, WeatherRepository(weatherService)) as T
            }
        }).get(DaysWeatherViewModel::class.java)

        val adapter = DaysWeatherListAdapter { item ->
            (requireActivity() as DaysFragmentCallback).onDaysFragmentCallback(item)
        }
        binding.weatherList.adapter = adapter

        viewModel.weatherListLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            binding.weatherSwipeRefreshLayout.isRefreshing = false
        }

        binding.weatherSwipeRefreshLayout.setOnRefreshListener {
            viewModel.refreshData()
        }
    }

    private class NoCityIdException(message: String) : Exception(message)

    companion object {
        const val ARG_CITY_ID = "cityId"
    }
}