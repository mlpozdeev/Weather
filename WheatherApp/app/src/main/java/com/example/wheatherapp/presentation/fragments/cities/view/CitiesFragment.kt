package com.example.wheatherapp.presentation.fragments.cities.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wheatherapp.R
import com.example.wheatherapp.databinding.FragmentCitiesBinding
import com.example.wheatherapp.presentation.fragments.cities.models.City
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

class CitiesFragment : Fragment() {

    private var _binding: FragmentCitiesBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCitiesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gson = GsonBuilder().create()
        val listOfCityObject = object : TypeToken<List<City>>() {}.type
        val cities = gson.fromJson<List<City>>(
            resources.openRawResource(R.raw.cities).reader(),
            listOfCityObject
        )

        binding.citiesList.adapter = CitiesListAdapter(cities) { cityId ->

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}