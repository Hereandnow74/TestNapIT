package com.gmail.klepikovmichael174.project1.feature.search.presentation

import moxy.MvpPresenter
import java.lang.Exception

class SearchPresenter() : MvpPresenter<SearchView>() {

    private var selectedType: TYPE = TYPE.SUN

    fun setType(type: TYPE) {
        selectedType = type
    }

    fun validate(tempFrom: String, tempTo: String) {
        when {
            !tempIsCorrect(tempFrom) -> viewState.showTempFromError()
            !tempIsCorrect(tempTo) -> viewState.showTempToError()
        }
    }

    private fun tempIsCorrect(tempText: String): Boolean {
        if (tempText.isEmpty()) return false

        return try {
            val temp = tempText.toInt()
            temp in -40..40
        } catch (e: Exception) {
            false
        }
    }
}