package com.gmail.klepikovmichael174.project1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Weather(val cityName: String, val cityTemp: String, val cityMaxTemp: String, val cityMinTemp: String, val cityPress: String) : Parcelable