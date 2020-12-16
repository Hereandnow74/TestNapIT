package com.gmail.klepikovmichael174.project1.feature.search

import java.lang.Exception

class SearchPresenter(private val view: SearchView) {

    var selectedType = TYPE.SUN

    fun setType(selectedType: TYPE) {
        this.selectedType = selectedType

    }

    fun validate(tempFrom: String, tempTo: String) {
        when {
            !tempIsCorrect(tempFrom) -> view.showTempFromError()
            !tempIsCorrect(tempTo) -> view.showTempToError()
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