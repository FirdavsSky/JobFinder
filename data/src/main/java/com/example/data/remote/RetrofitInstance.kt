package com.example.data.remote

import com.example.data.Const
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val client = OkHttpClient.Builder()
        .addInterceptor(APILoggingInterceptor())
        .followRedirects(true) // Убедитесь, что редиректы следуют
        .build()

    val api: Api by lazy {
        Retrofit.Builder()
            .baseUrl("https://drive.usercontent.google.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }
}