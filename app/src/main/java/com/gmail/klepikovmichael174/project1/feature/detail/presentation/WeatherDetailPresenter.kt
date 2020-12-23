package com.gmail.klepikovmichael174.project1.feature.detail.presentation

import com.gmail.klepikovmichael174.project1.Weather
import com.gmail.klepikovmichael174.project1.data.FavoritesDao
import moxy.MvpPresenter
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

class WeatherDetailPresenter(
    private val weather: Weather,
    private val favoritesDao: FavoritesDao
) : MvpPresenter<WeatherDetailView>() {

    private var isInFavorites: Boolean = false

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setWeather(weather)
        isInFavorites = favoritesDao.isInFavorites(weather)
        viewState.setIsInFavorites(isInFavorites)
    }

    fun onFavoritesClicked(){
        if (isInFavorites){
            favoritesDao.delete(weather)
        } else {
            favoritesDao.add(weather)
        }
        isInFavorites = !isInFavorites
        viewState.setIsInFavorites(isInFavorites)
    }

}

interface WeatherDetailView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    abstract fun setWeather(weather: Weather)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setIsInFavorites(inFavorites: Boolean)

}