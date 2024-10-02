package com.example.data.model


import com.google.gson.annotations.SerializedName

data class VacancyResult(
    @SerializedName("offers")
    val offers: List<Offer>,

    @SerializedName("vacancies")
    val vacancies: List<Vacancy>
)