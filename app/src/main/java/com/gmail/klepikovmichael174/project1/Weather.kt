package com.gmail.klepikovmichael174.project1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Weather (val cityName: String, val cityWeath: String, val cityTemp: String) : Parcelable