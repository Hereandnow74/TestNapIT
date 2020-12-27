package com.gmail.klepikovmichael174.project1.domain

import com.gmail.klepikovmichael174.project1.Weather
import com.gmail.klepikovmichael174.project1.data.entity.Main
import com.gmail.klepikovmichael174.project1.di.WeatherApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetTopWeatherUseCase @Inject constructor(
    private val weatherApi: WeatherApi
    ) {

    suspend operator fun invoke(): List<Weather> = withContext(Dispatchers.IO) {
        weatherApi.getTopCities(lat = "55.5", lon = "37.5", appid = "a992a79a359fb0ee88aacab7c295a019").run {
            list?.mapNotNull { list ->
                Weather(
                    cityName = list.name ?: return@mapNotNull null
                )
            } ?: emptyList()
            }
        }
}