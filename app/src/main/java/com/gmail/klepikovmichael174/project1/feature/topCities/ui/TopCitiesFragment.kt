package com.gmail.klepikovmichael174.project1.feature.topCities.ui

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.gmail.klepikovmichael174.project1.R
import com.gmail.klepikovmichael174.project1.Weather
import com.gmail.klepikovmichael174.project1.feature.search.presentation.SearchFragment
import com.gmail.klepikovmichael174.project1.feature.topCities.presentation.TopCitiesPresenter
import com.gmail.klepikovmichael174.project1.feature.topCities.presentation.TopCitiesView
import com.gmail.klepikovmichael174.project1.ui.AllCitiesFragment
import com.gmail.klepikovmichael174.project1.ui.WeatherDetailsFragment
import kotlinx.android.synthetic.main.fragment_top_cities.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class TopCitiesFragment : MvpAppCompatFragment(R.layout.fragment_top_cities), TopCitiesView {

    private var weathersAdapter: TopWeathersAdapter? = null
    private val presenter: TopCitiesPresenter by moxyPresenter {
        TopCitiesPresenter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnGoToSearch.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, SearchFragment())
                .addToBackStack("SearchFragment")
                .commit()
        }

        with(rvTopCities) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = TopWeathersAdapter(onCityClick = { weather ->
                presenter.onCityClick(weather)
            }).also {
                weathersAdapter = it
            }
        }


    }

    override fun onDestroy() {
        weathersAdapter = null
        super.onDestroy()
    }


    override fun setWeathers(weathers: List<Weather>) {
        weathersAdapter?.submitList(weathers)
    }

    override fun openWeatherDetails(weather: Weather) {
        requireFragmentManager().beginTransaction()
            .replace(R.id.container, WeatherDetailsFragment.newInstance(weather))
            .addToBackStack("WeatherDetailsFragment")
            .commit()
    }

}

