package com.gmail.klepikovmichael174.project1.di

import com.gmail.klepikovmichael174.project1.data.entity.TopWeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("data/2.5/find")
    suspend fun getTopCities(
        @Query("lat") lat: String = "55.5",
        @Query("lon") lon: String = "37.5",
        @Query("cnt") cnt: String = "40",
        @Query("units") units: String = "metric",
        @Query("appid") appid: String = "a992a79a359fb0ee88aacab7c295a019"
    ): TopWeatherResponse
}