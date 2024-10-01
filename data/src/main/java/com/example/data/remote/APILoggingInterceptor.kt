package com.example.data.remote

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody
import okio.Buffer
import java.io.IOException
import java.util.Locale

private val TAG: String = "Vacancy.REST"

class APILoggingInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val response = chain.proceed(originalRequest)

        val time: Long = System.currentTimeMillis()

        val responseBody = response.body()
        val contentType = responseBody?.contentType()
        val content = responseBody?.string()

        Log.d(TAG, "-----------------------------START-------------------------------")
        Log.d(
            TAG, "${originalRequest.method()} ${originalRequest.url()} ${bodyToString(originalRequest)}"
        )
        Log.d(
            TAG, String.format(
                Locale.getDefault(), "Response by %dms: code:%s, body=%s",
                (System.currentTimeMillis() - time), response.code(), content
            )
        )
        Log.d(TAG, "------------------------------END-------------------------------")


        return response.newBuilder()
            .body(ResponseBody.create(contentType, content ?: ""))
            .build()
    }


    private fun bodyToString(request: Request): String {
        return try {
            val copy: Request = request.newBuilder().build()
            val buffer = Buffer()
            copy.body()?.writeTo(buffer)
            buffer.readUtf8()
        } catch (e: IOException) {
            Log.e(TAG, e.message ?: "Unknown error")
            ""
        }
    }
}
