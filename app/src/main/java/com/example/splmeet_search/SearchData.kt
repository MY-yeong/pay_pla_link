package com.example.splmeet_search

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchData(
    @SerializedName("date") val date: String,
    @SerializedName("place") val place: String,
    @SerializedName("price") val price: String):Parcelable {
    annotation class SerializedName(val value: String)
}
