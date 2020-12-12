package com.gmail.klepikovmichael174.project1.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gmail.klepikovmichael174.project1.R
import com.gmail.klepikovmichael174.project1.Weather
import kotlinx.android.synthetic.main.fragment_weather_details.*


class WeatherDetailsFragment : Fragment(R.layout.fragment_weather_details) {

    companion object {

        private const val WEATHER = "WEATHER"

        fun newInstance(weather: Weather) =
            WeatherDetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(WEATHER, weather)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnBack.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, CitiesFragment())
                .addToBackStack("CitiesFragment")
                .commit()
        }

        arguments?.let {
            val weather = it.getParcelable<Weather>(WEATHER)

            cityCheck.text = "Город: ${weather?.cityName}"
            weatherCheck.text = "Погода: ${weather?.cityWeath}"
            tempCheck.text = "Температура: ${weather?.cityTemp}"

        }
    }

}