package com.example.weatherapp.presentation.fragments.days_weather.view

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.weatherapp.presentation.fragments.days_weather.model.DayWeatherItem

class DaysWeatherListAdapter : ListAdapter<DayWeatherItem, DaysWeatherViewHolder>(ITEM_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DaysWeatherViewHolder {
        return DaysWeatherViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: DaysWeatherViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        private val ITEM_COMPARATOR = object : DiffUtil.ItemCallback<DayWeatherItem>() {
            override fun areItemsTheSame(oldItem: DayWeatherItem, newItem: DayWeatherItem): Boolean {
                return oldItem.date == newItem.date
            }

            override fun areContentsTheSame(oldItem: DayWeatherItem, newItem: DayWeatherItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}