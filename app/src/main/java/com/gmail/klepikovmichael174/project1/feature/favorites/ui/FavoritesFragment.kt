package com.gmail.klepikovmichael174.project1.feature.favorites.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.gmail.klepikovmichael174.project1.R
import com.gmail.klepikovmichael174.project1.Weather
import com.gmail.klepikovmichael174.project1.data.FavoritesDaoImp
import com.gmail.klepikovmichael174.project1.feature.detail.ui.WeatherDetailsFragment
import com.gmail.klepikovmichael174.project1.feature.favorites.presentation.FavoritesPresenter
import com.gmail.klepikovmichael174.project1.feature.favorites.presentation.FavoritesView
import com.gmail.klepikovmichael174.project1.feature.topCities.ui.TopWeathersAdapter
import kotlinx.android.synthetic.main.favorites_fragment.*
import moxy.MvpAppCompatFragment
import moxy.MvpView
import moxy.ktx.moxyPresenter
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

class FavoritesFragment : MvpAppCompatFragment(R.layout.favorites_fragment), FavoritesView {

    companion object{
        fun newInstance() = FavoritesFragment()
    }

    private val presenter:FavoritesPresenter by moxyPresenter {
        FavoritesPresenter(
            favoritesDao = FavoritesDaoImp(requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)
            )
        )
    }

    private var favoritesAdapter: TopWeathersAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(favoritesList){
            favoritesAdapter = TopWeathersAdapter(onCityClick = { weather ->
                presenter.onMainCityClick(weather)
            })
            layoutManager = LinearLayoutManager(context)
            adapter = favoritesAdapter
        }
    }

    override fun setWeathers(weathers: List<Weather>) {
        favoritesAdapter?.submitList(weathers)
    }

    override fun openMainWeatherDetails(weather: Weather) {
        requireFragmentManager().beginTransaction()
            .replace(R.id.container, WeatherDetailsFragment.newInstance(weather))
            .addToBackStack("WeatherDetailsFragment")
            .commit()
    }
}
