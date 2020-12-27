package com.gmail.klepikovmichael174.project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gmail.klepikovmichael174.project1.feature.topCities.ui.TopCitiesFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (savedInstanceState == null) {
        val fragmentManager = supportFragmentManager

            if (fragmentManager.fragments.size == 0) {
            fragmentManager.beginTransaction()
                .add(R.id.container, TopCitiesFragment())
                .commit()
            }
        }

    }
}