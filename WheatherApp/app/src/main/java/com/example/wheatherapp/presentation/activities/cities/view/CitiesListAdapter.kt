package com.example.wheatherapp.presentation.activities.cities.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wheatherapp.presentation.activities.cities.model.City

class CitiesListAdapter(
    private val cities: List<City>,
    private val onItemClicked: (Int) -> Unit
) : RecyclerView.Adapter<CityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        return CityViewHolder.create(parent) { position ->
            val item = cities[position]
            onItemClicked(item.id)
        }
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val city = cities[position]
        holder.bind(city)
    }

    override fun getItemCount(): Int {
        return cities.size
    }
}