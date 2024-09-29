package com.example.jobfinder.utils

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target


fun <T : View> RecyclerView.ViewHolder.findViewById(@IdRes id: Int): T {

    return itemView.findViewById(id)
}
fun <T : View> Fragment.findViewById(@IdRes id: Int): T {

    return view?.findViewById(id) ?: throw Exception("view is no initialized !")
}

fun ViewGroup.inflateView(@LayoutRes layoutId: Int): View {

    val inflater = LayoutInflater.from(context)
    return inflater.inflate(layoutId, this, false)
}

fun ImageView.loadImage(url: String?, loadingState: (state: Boolean) -> Unit) {

    loadingState.invoke(true)

    url?.let {
        Glide.with(this.context)
            .load(it)
            //.apply(RequestOptions().placeholder(R.drawable.news_placeholder))
            .listener(object : RequestListener<Drawable> {

                override fun onResourceReady(
                    resource: Drawable,
                    model: Any,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    dataSource: DataSource,
                    isFirstResource: Boolean
                ): Boolean {
                    loadingState.invoke(false)
                    return false
                }

                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>,
                    isFirstResource: Boolean
                ): Boolean {
                    loadingState.invoke(false)
                    return false
                }
            })
            .into(this)
    } ?: run {
        loadingState.invoke(false)
    }
}