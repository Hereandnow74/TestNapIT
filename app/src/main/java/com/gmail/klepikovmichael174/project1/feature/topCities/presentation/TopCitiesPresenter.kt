package com.gmail.klepikovmichael174.project1.feature.topCities.presentation

import android.util.Log
import com.gmail.klepikovmichael174.project1.Weather
import com.gmail.klepikovmichael174.project1.domain.GetTopWeatherUseCase
import com.gmail.klepikovmichael174.project1.extensions.launchWithErrorHandler
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.MvpView
import moxy.presenterScope
import moxy.viewstate.strategy.*
import javax.inject.Inject

class TopCitiesPresenter @Inject constructor(
    private val getTopWeatherUseCase: GetTopWeatherUseCase
    ) : MvpPresenter<TopCitiesView>() {


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showLoading(isShow = true)
        presenterScope.launchWithErrorHandler(block = {
            val weathers = getTopWeatherUseCase()
            viewState.setWeathers(weathers)
            viewState.showLoading(isShow = false)
        }, onError = {
            viewState.showLoading(isShow = false)
        })
    }

    fun onCityClick(weather: Weather) {
        viewState.openWeatherDetails(weather)
    }

    fun onFavoritesClick() {
        viewState.openFavoritesScreen()
    }
}



interface TopCitiesView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setWeathers(weathers: List<Weather>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun openWeatherDetails(weather: Weather)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun openFavoritesScreen()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showLoading(isShow: Boolean)
}
