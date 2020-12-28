package com.gmail.klepikovmichael174.project1.feature.favorites.presentation

import com.gmail.klepikovmichael174.project1.Weather
import com.gmail.klepikovmichael174.project1.data.FavoritesDao
import moxy.MvpPresenter
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

class FavoritesPresenter(
    private val favoritesDao: FavoritesDao
) : MvpPresenter<FavoritesView>() {

    private var weathers: List<Weather> = emptyList()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        weathers = favoritesDao.getAll()
        viewState.setWeathers(weathers)
    }

    fun onMainCityClick(weather: Weather) {
        viewState.openMainWeatherDetails(weather)
    }
}

interface FavoritesView:MvpView{

    @StateStrategyType(AddToEndSingleStrategy::class)
    abstract fun setWeathers(weathers: List<Weather>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun openMainWeatherDetails(weather: Weather)
}