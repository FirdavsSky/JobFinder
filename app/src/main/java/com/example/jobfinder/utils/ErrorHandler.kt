package com.example.jobfinder.utils

import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException


class ErrorHandler {

    fun getErrorMessage(exception: Exception): String{

        val errorMessage = when (exception) {
            is ConnectException -> "No Internet connection. Please check your network settings."
            is SocketTimeoutException -> "Connection timed out. Please try again later."
            is UnknownHostException -> "Unable to connect to the server. Please check your internet connection."
            else -> "An error occurred: ${exception.message}"
        }
        return errorMessage
    }
}