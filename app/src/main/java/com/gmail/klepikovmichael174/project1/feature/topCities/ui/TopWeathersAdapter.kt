package com.gmail.klepikovmichael174.project1.feature.topCities.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gmail.klepikovmichael174.project1.R
import com.gmail.klepikovmichael174.project1.Weather
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.top_cities_item.*

class TopWeathersAdapter(private val onCityClick: (Weather) -> Unit) :
    ListAdapter<Weather, TopWeathersAdapter.ViewHolder>(object : DiffUtil.ItemCallback<Weather>() {
        override fun areItemsTheSame(oldItem: Weather, newItem: Weather): Boolean {
            return oldItem.cityName == newItem.cityName
        }

        override fun areContentsTheSame(oldItem: Weather, newItem: Weather): Boolean {
            return oldItem == newItem
        }
    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.top_cities_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.containerView.setOnClickListener {
            onCityClick(item)
        }
        holder.topCitiesName.text = item.cityName
        holder.topCitiesWeather.text = item.cityWeath
        holder.topCitiesTemperature.text = item.cityTemp

    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer
}