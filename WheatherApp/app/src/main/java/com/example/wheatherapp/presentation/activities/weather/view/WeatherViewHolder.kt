package com.example.wheatherapp.presentation.activities.weather.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wheatherapp.R
import com.example.wheatherapp.presentation.activities.weather.model.WeatherItem

class WeatherViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val dateTextView: TextView = view.findViewById(R.id.date_text_view)
    private val temperatureTextView: TextView = view.findViewById(R.id.temperature_text_view)

    fun bind(item: WeatherItem) {
        dateTextView.text = item.date
        temperatureTextView.text = item.temperature
    }

    companion object {
        fun create(parent: ViewGroup): WeatherViewHolder {
            val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.weather_item, parent, false)

            return WeatherViewHolder(view)
        }
    }
}