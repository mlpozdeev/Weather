package com.example.weatherapp.presentation.activities.cities.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wheatherapp.R
import com.example.weatherapp.presentation.activities.cities.model.City

class CityViewHolder(view: View, onItemClicked: (Int) -> Unit) : RecyclerView.ViewHolder(view) {

    private val cityNameTextView: TextView = view.findViewById(R.id.city_name_text_view)

    init {
        itemView.setOnClickListener {
            onItemClicked(adapterPosition)
        }
    }

    fun bind(item: City) {
        cityNameTextView.text = item.name
    }

    companion object {
        fun create(parent: ViewGroup, onItemClicked: (Int) -> Unit): CityViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.city_item, parent, false)
            return CityViewHolder(view, onItemClicked)
        }
    }
}