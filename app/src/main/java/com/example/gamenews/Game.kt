package com.example.gamenews

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Game(
    val name :String,
    val dev :String,
    val price :String,
    val photo :Int,
    val desc :String,
    val rate: String
) :Parcelable
