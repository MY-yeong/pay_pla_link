package com.example.splmeet_search

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchData(
    @SerializedName("name") val name: String,
    @SerializedName("intro") val intro: String,
    @SerializedName("addr") val addr: String,
    @SerializedName("price") val price: String):Parcelable {
    annotation class SerializedName(val value: String)
}
