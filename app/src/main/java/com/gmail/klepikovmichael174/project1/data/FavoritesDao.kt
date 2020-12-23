package com.gmail.klepikovmichael174.project1.data

import com.gmail.klepikovmichael174.project1.Weather

interface FavoritesDao {

    /**
     * добавить [weather] в избранное
     */
    fun add (weather: Weather)
    /**
     * удаление [weather] в избранное
     */
    fun delete (weather: Weather)
    /**
     * @return избранные города
     * может быть пустым
     */
    fun getAll(): List<Weather>
    /**
     * @return true если город в избранном, иначе
     */
    fun isInFavorites(weather: Weather): Boolean
}

