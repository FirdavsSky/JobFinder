package com.example.data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object VacanciesClient {

    //ToDo: Use NDK to store Url
    private const val BASE_URL = "https://drive.usercontent.google.com/"

    private val client = OkHttpClient.Builder()
        .addInterceptor(APILoggingInterceptor())
        .followRedirects(true)
        .build()

    val api: VacancyService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(VacancyService::class.java)
    }
}