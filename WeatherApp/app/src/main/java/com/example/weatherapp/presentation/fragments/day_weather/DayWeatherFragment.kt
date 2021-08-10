package com.example.weatherapp.presentation.fragments.day_weather

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wheatherapp.R
import com.example.wheatherapp.databinding.FragmentDayWeatherBinding

class DayWeatherFragment : Fragment() {

    private var _binding: FragmentDayWeatherBinding? = null

    private val binding get() = _binding!!

    private lateinit var date: String

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

        date = requireArguments().getString(ARG_DATE)!!

        binding.dateTextView.text = date
    }

    companion object {

        private const val ARG_DATE = "date"

        fun newInstance(
            date: String
        ): DayWeatherFragment {
            return DayWeatherFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_DATE, date)
                }
            }
        }
    }
}