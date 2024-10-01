package com.example.data.remote

import com.example.data.model.VacancyResult
import retrofit2.http.GET

interface VacancyService {
    @GET("u/0/uc?id=1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r&export=download")
    suspend fun fetchAllVacancies(): VacancyResult
}