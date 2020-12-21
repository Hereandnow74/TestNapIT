package com.gmail.klepikovmichael174.project1.feature.search.presentation

import moxy.MvpView
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType

interface SearchView : MvpView {

    @StateStrategyType(SkipStrategy::class)
    fun showTempFromError()

    @StateStrategyType(SkipStrategy::class)
    fun showTempToError()
}