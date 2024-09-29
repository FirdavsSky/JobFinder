package com.example.jobfinder.core_ui

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

open class BaseFragment(@LayoutRes layoutId: Int) : Fragment(layoutId) {

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onInitViews()
        onInitListeners()
    }


    protected open fun onInitViews() = Unit

    protected open fun onInitListeners() = Unit

}