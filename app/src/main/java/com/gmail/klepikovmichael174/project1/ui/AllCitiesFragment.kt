package com.gmail.klepikovmichael174.project1.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.gmail.klepikovmichael174.project1.R
import com.gmail.klepikovmichael174.project1.feature.topCities.ui.TopCitiesFragment
import kotlinx.android.synthetic.main.fragment_all_cities.*

class AllCitiesFragment : Fragment(R.layout.fragment_all_cities) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnBackToCities.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, TopCitiesFragment())
                .addToBackStack("CitiesFragment")
                .commit()
        }
    }
}