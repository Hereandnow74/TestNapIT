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
        weatherApi.getTopCities(lat = "55.7", lon = "37.6", cnt = "25").run {
            list?.mapNotNull { list ->
                Weather(
                    cityName = list.name ?: return@mapNotNull null,
                    cityTemp = (list.main?.temp ?: return@mapNotNull null).toString(),
                    cityMaxTemp = (list.main?.tempMax ?: return@mapNotNull null).toString(),
                    cityMinTemp = (list.main?.tempMin ?: return@mapNotNull null).toString(),
                    cityPress = (list.main?.pressure ?: return@mapNotNull null).toString()
                )
            } ?: emptyList()
            }
        }
}
