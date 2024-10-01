package com.example.data.model

import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("town")
    val town: String,

    @SerializedName("street")
    val street: String,

    @SerializedName("house")
    val house: String
)
