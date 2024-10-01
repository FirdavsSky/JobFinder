package com.example.data.model

import com.google.gson.annotations.SerializedName

data class Experience(
    @SerializedName("preview_text")
    val previewText: String,

    @SerializedName("text")
    val text: String
)
