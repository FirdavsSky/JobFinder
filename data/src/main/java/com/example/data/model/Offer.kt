package com.example.data.model

import com.google.gson.annotations.SerializedName

data class Offer(
    @SerializedName("id")
    val id: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("link")
    val link: String,

    @SerializedName("button")
    val button: Button? = null
)
