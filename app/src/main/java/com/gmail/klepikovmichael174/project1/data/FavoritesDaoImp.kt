package com.gmail.klepikovmichael174.project1.data

import android.content.SharedPreferences
import com.gmail.klepikovmichael174.project1.Weather
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.Json.Default.decodeFromString

class FavoritesDaoImp(
    private val sharedPreferences: SharedPreferences
) : FavoritesDao {

    private var weathers:List<Weather>
        get() = sharedPreferences.getString(FAVORITES_DAO_KEY, null)?.let {
            try {
                Json.decodeFromString<List<Weather>>(it)
            } catch (t: Throwable) {
                emptyList()
            }
        } ?: emptyList()

        set(value){
                sharedPreferences.edit().putString(
                FAVORITES_DAO_KEY,
                Json.encodeToString(value)
            ).apply()
        }

    override fun add(weather: Weather) {
        weathers = weathers + weather
    }

    override fun delete(weather: Weather) {
        weathers = weathers.filter { it != weather }
    }

    override fun getAll(): List<Weather> = weathers
    override fun isInFavorites(weather: Weather): Boolean = weathers.contains(weather)

    companion object {
        private const val FAVORITES_DAO_KEY = "FAVORITES_DAO_KEY"
    }
}