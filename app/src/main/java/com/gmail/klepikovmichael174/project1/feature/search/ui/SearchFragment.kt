package com.gmail.klepikovmichael174.project1.feature.search.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import com.gmail.klepikovmichael174.project1.R
import com.gmail.klepikovmichael174.project1.feature.topCities.ui.TopCitiesFragment
import kotlinx.android.synthetic.main.fragment_search.*

enum class TYPE { SUN, RAIN, SNOW }

class SearchFragment : Fragment(R.layout.fragment_search), SearchView {

    private val presenter = SearchPresenter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.attachView(this)
        initListeners()
    }

    private fun initListeners() {

        rgType.setOnCheckedChangeListener { radioGroup, i ->
            val selectedType = when (i) {
                R.id.rbRainy -> TYPE.RAIN
                R.id.rbSnowy -> TYPE.SNOW
                else -> TYPE.SUN
            }

            presenter.setType(selectedType)
        }

        btnSearch.setOnClickListener {
            presenter.validate(
                etTempFrom.text.toString(),
                etTempTo.text.toString()
            )
        }
    }

    override fun showTempFromError() {
        showError("Температура от")
    }

    override fun showTempToError() {
        showError("Температура до")
    }

    private fun showError(name: String) {
        Toast.makeText(requireContext(), "Ошибка в поле $name", Toast.LENGTH_LONG).show()
    }
}