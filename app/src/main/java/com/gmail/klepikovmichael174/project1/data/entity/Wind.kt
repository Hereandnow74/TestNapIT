package com.gmail.klepikovmichael174.project1.data.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Wind(
    @SerialName("deg")
    val deg: Int?,
    @SerialName("speed")
    val speed: Int?
)