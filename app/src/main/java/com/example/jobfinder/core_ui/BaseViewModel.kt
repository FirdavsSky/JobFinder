package com.example.jobfinder.core_ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jobfinder.utils.ErrorHandler


open class BaseViewModel : ViewModel() {

    private val errorHandler = ErrorHandler()

    private val mErrorResult = MutableLiveData<String>()
    val errorResult: LiveData<String> = mErrorResult


    protected fun getErrorMessage(exception: Exception) {
        mErrorResult.postValue(errorHandler.getErrorMessage(exception))
    }
}