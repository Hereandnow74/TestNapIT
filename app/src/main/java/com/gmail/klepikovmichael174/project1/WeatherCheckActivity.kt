package com.gmail.klepikovmichael174.project1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_weather_check.*

class WeatherCheckActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_check)

        val weather = intent.extras?.getSerializable("City") as Weather

        cityCheck.text = "Город: ${weather.city}"
        weatherCheck.text = "Погода: ${weather.weath}"
        tempCheck.text = "Температура: ${weather.temp}"

        btnMainActivity.setOnClickListener {
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
        }
    }
}