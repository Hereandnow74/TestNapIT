package com.gmail.klepikovmichael174.project1.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gmail.klepikovmichael174.project1.R
import com.gmail.klepikovmichael174.project1.Weather
import com.gmail.klepikovmichael174.project1.feature.search.SearchFragment
import kotlinx.android.synthetic.main.fragment_cities.*
import kotlinx.android.synthetic.main.fragment_weather_details.*

class CitiesFragment : Fragment(R.layout.fragment_cities) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val weather = Weather("Челябинск","Солнечно","- 10 C")

        btnWeatherCheck.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, WeatherDetailsFragment.newInstance(weather))
                .addToBackStack("WeatherDetailsFragment")
                .commit()
        }

        btnAllCities.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, AllCitiesFragment())
                .addToBackStack("AllCitiesFragment")
                .commit()
        }

        btnGoToSearch.setOnClickListener{
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, SearchFragment())
                .addToBackStack("SearchFragment")
                .commit()
        }
    }
}