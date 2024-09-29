package com.example.jobfinder.core_ui

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

open class BaseVMFragment<VM : ViewModel>(@LayoutRes layoutId: Int, vmClass: Class<VM>) :
    BaseFragment(layoutId) {

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onInitObservers()
    }

    protected val viewModel: VM by lazy {
        ViewModelProvider(this)[vmClass]
    }

    protected open fun onInitObservers() = Unit

    protected fun <T> LiveData<T>.observe(observer: Observer<T>) {
        observe(viewLifecycleOwner, observer)
    }
}