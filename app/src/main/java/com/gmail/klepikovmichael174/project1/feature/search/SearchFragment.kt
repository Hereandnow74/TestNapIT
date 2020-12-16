package com.gmail.klepikovmichael174.project1.feature.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import com.gmail.klepikovmichael174.project1.R
import kotlinx.android.synthetic.main.fragment_search.*

enum class TYPE {SUN, RAIN, SNOW}

class SearchFragment : Fragment(R.layout.fragment_search), SearchView {

    val presenter = SearchPresenter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {

        rgType.setOnCheckedChangeListener { group: RadioGroup?, checkedId: Int ->

            val selectedType = when (checkedId){
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

    private fun showError(name: String){
        Toast.makeText(requireContext(), "Ошибка в поле $name", Toast.LENGTH_LONG).show()
    }
}