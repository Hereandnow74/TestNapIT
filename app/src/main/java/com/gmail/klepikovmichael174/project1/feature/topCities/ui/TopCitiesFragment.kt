package com.gmail.klepikovmichael174.project1.feature.topCities.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.gmail.klepikovmichael174.project1.R
import com.gmail.klepikovmichael174.project1.Weather
import com.gmail.klepikovmichael174.project1.domain.GetTopWeatherUseCase
import com.gmail.klepikovmichael174.project1.feature.search.presentation.SearchFragment
import com.gmail.klepikovmichael174.project1.feature.topCities.presentation.TopCitiesPresenter
import com.gmail.klepikovmichael174.project1.feature.topCities.presentation.TopCitiesView
import com.gmail.klepikovmichael174.project1.feature.detail.ui.WeatherDetailsFragment
import com.gmail.klepikovmichael174.project1.feature.favorites.ui.FavoritesFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_top_cities.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

@AndroidEntryPoint
class TopCitiesFragment : MvpAppCompatFragment(R.layout.fragment_top_cities), TopCitiesView {

    @Inject
    lateinit var topCitiesPresenter: TopCitiesPresenter

    private var weathersAdapter: TopWeathersAdapter? = null
    private val presenter: TopCitiesPresenter by moxyPresenter { topCitiesPresenter }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btnGoToFavorites.setOnClickListener {
            presenter.onFavoritesClick()
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

    override fun showLoading(isShow: Boolean) {
        topWeatherProgress.isVisible = isShow
    }

    override fun openWeatherDetails(weather: Weather) {
        requireFragmentManager().beginTransaction()
            .replace(R.id.container, WeatherDetailsFragment.newInstance(weather))
            .addToBackStack("WeatherDetailsFragment")
            .commit()
    }

    override fun openFavoritesScreen(){
        requireFragmentManager().beginTransaction()
            .replace(R.id.container, FavoritesFragment())
            .addToBackStack("FavoritesFragment")
            .commit()
    }

}

