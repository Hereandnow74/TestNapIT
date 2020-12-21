package com.gmail.klepikovmichael174.project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gmail.klepikovmichael174.project1.feature.topCities.ui.TopCitiesFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager

        fragmentManager.beginTransaction()
            .add(R.id.container, TopCitiesFragment())
            .commit()
    }
}