package com.gmail.klepikovmichael174.project1.feature.topCities.presentation

import com.gmail.klepikovmichael174.project1.Weather
import moxy.MvpPresenter
import moxy.MvpView
import moxy.viewstate.strategy.*

class TopCitiesPresenter : MvpPresenter<TopCitiesView>() {

    private var weathers: List<Weather> = listOf(
        Weather("Челябинск", "Солнечно", "- 10 C"),
        Weather("Магнитогорск", "Дождь", "- 12 C"),
        Weather("Миасс", "Солнечно", "- 13 C"),
        Weather("Екатеринбург", "Снег", "- 15 C"),
        Weather("Новосибирск", "Солнечно", "- 8 C")
    )

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setWeathers(weathers)
    }

    fun onCityClick(weather: Weather) {
//        viewState.openWeatherDetails(weather)
        weathers = weathers.filter { it != weather }
        viewState.setWeathers(weathers)
    }
}

interface TopCitiesView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setWeathers(weathers: List<Weather>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun openWeatherDetails(weather: Weather)


}
