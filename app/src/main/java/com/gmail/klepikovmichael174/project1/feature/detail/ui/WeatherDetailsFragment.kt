package com.gmail.klepikovmichael174.project1.feature.detail.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.gmail.klepikovmichael174.project1.R
import com.gmail.klepikovmichael174.project1.Weather
import com.gmail.klepikovmichael174.project1.data.FavoritesDaoImp
import com.gmail.klepikovmichael174.project1.feature.detail.presentation.WeatherDetailPresenter
import com.gmail.klepikovmichael174.project1.feature.detail.presentation.WeatherDetailPresenterFactory
import com.gmail.klepikovmichael174.project1.feature.detail.presentation.WeatherDetailView
import com.gmail.klepikovmichael174.project1.feature.topCities.ui.TopCitiesFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_weather_details.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

@AndroidEntryPoint
class WeatherDetailsFragment : MvpAppCompatFragment(R.layout.fragment_weather_details), WeatherDetailView {

    companion object {

        private const val WEATHER = "WEATHER"

        fun newInstance(weather: Weather) =
            WeatherDetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(WEATHER, weather)
                }
            }
    }

    @Inject
    lateinit var weatherDetailPresenterFactory: WeatherDetailPresenterFactory
    private val presenter: WeatherDetailPresenter by moxyPresenter {
        weatherDetailPresenterFactory.create(arguments?.getParcelable(WEATHER)!!)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        weatherDetailFavorite.setOnClickListener {
            presenter.onFavoritesClicked()
        }

        btnBack.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, TopCitiesFragment())
                .addToBackStack("CitiesFragment")
                .commit()
        }

        arguments?.let {
            val weather = it.getParcelable<Weather>(WEATHER)



        }
    }

    override fun setWeather(weather: Weather) {
        cityCheck.text = "Город: ${weather.cityName}"
    }

    override fun setIsInFavorites(inFavorites: Boolean) {
        weatherDetailFavorite.setImageResource(
            if(inFavorites) R.drawable.ic_baseline_favorite_24 else R.drawable.ic_baseline_favorite_border_24
        )
    }
}