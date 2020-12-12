package com.gmail.klepikovmichael174.project1.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gmail.klepikovmichael174.project1.R
import com.gmail.klepikovmichael174.project1.Weather
import kotlinx.android.synthetic.main.fragment_all_cities.*
import kotlinx.android.synthetic.main.fragment_cities.*

class AllCitiesFragment : Fragment(R.layout.fragment_all_cities) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnBackToCities.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, CitiesFragment())
                .addToBackStack("CitiesFragment")
                .commit()
        }
    }
}