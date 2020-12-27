package com.gmail.klepikovmichael174.project1.data.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TopWeatherResponse(
    @SerialName("cod")
    val cod: String?,
    @SerialName("count")
    val count: Int?,
    @SerialName("list")
    val list: List<list>?,
    @SerialName("message")
    val message: String?
)