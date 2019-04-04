package com.panch.mvvmstarterapp.ui.renderers

import android.app.Activity
import android.graphics.Point
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.ViewCompat
import com.bumptech.glide.Glide
import com.panch.mvvmstarterapp.R
import com.panch.mvvmstarterapp.data.apiBaseUrl
import com.panch.mvvmstarterapp.data.rest.PhotoModel
import com.pedrogomez.renderers.Renderer
import kotlinx.android.synthetic.main.item_photo.view.*
import timber.log.Timber

class PhotoRenderer(private val listener: PhotoClickListener) : Renderer<PhotoModel>() {

    override fun inflate(inflater: LayoutInflater?, parent: ViewGroup?): View {
        return inflater!!.inflate(R.layout.item_photo, parent, false)
    }

    override fun hookListeners(rootView: View?) {
        rootView!!.imageView.setOnClickListener {
            listener.onClickPhoto(content, rootView.imageView)
        }
    }

    override fun render() {
        Glide.with(context)
            .load("${apiBaseUrl}300/?image=${content.id}")
            .into(rootView!!.imageView)
    }

    override fun setUpView(rootView: View?) {
        val display = (context as Activity).windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        val width = size.x
        rootView!!.layoutParams.height = (width / 2)
    }

    interface PhotoClickListener {
        fun onClickPhoto(photoModel: PhotoModel, imageView: ImageView)
    }
}