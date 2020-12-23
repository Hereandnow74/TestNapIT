package com.gmail.klepikovmichael174.project1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Weather (val cityName: String, val cityWeath: String, val cityTemp: String) : Parcelable