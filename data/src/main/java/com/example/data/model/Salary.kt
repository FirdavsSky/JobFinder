package com.example.data.model

import com.google.gson.annotations.SerializedName

data class Salary(
    @SerializedName("short")
    val short: String? = null,

    @SerializedName("full")
    val full: String
)
