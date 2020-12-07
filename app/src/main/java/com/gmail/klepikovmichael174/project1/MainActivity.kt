package com.gmail.klepikovmichael174.project1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_weather_check.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnWeatherCheck.setOnClickListener {
            val weather = Weather("Челябинск", "Дождливо","- 12 C")

            val intent = Intent(this, WeatherCheckActivity::class.java)
            intent.putExtra("City", weather)
            startActivity(intent)
        }

    }
}