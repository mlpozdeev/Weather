package com.example.weatherapp.presentation.fragments.weather.days_weather.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wheatherapp.R
import com.example.weatherapp.presentation.fragments.weather.model.DayWeatherItem

class DaysWeatherViewHolder(
    view: View,
    onItemClicked: (Int) -> Unit
) : RecyclerView.ViewHolder(view) {

    private val dateTextView: TextView = view.findViewById(R.id.date_text_view)
    private val temperatureTextView: TextView = view.findViewById(R.id.temperature_text_view)

    init {
        itemView.setOnClickListener {
            onItemClicked(adapterPosition)
        }
    }

    fun bind(item: DayWeatherItem) {
        dateTextView.text = item.date
        temperatureTextView.text = item.temperature
    }

    companion object {
        fun create(parent: ViewGroup, onItemClicked: (Int) -> Unit): DaysWeatherViewHolder {
            val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.weather_item, parent, false)

            return DaysWeatherViewHolder(view, onItemClicked)
        }
    }
}