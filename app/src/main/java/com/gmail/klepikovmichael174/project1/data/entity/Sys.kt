package com.gmail.klepikovmichael174.project1.data.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Sys(
    @SerialName("country")
    val country: String?
)