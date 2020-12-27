package com.gmail.klepikovmichael174.project1.di

import android.app.Application
import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import com.gmail.klepikovmichael174.project1.data.FavoritesDao
import com.gmail.klepikovmichael174.project1.data.FavoritesDaoImp
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideWeatherApi(): WeatherApi = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/")
        .client(OkHttpClient.Builder().addInterceptor { chain ->
            val request = chain.request().newBuilder().run {
                header("WeatherCheck", "a992a79a359fb0ee88aacab7c295a019")
                build()
            }
            chain.proceed(request)
        }.build())
        .addConverterFactory(Json(builderAction = {
            ignoreUnknownKeys = true
        }).asConverterFactory("application/json".toMediaType()))
        .build()
        .create()

    @Provides
    fun provideFavoritesDao(@ApplicationContext context: Context): FavoritesDao = FavoritesDaoImp(
        context.getSharedPreferences("data", Context.MODE_PRIVATE)
    )
}