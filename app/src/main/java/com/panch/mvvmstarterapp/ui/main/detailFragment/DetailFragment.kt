package com.panch.mvvmstarterapp.ui.main.detailFragment

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.appcompat.app.ActionBar
import androidx.core.view.ViewCompat
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.panch.mvvmstarterapp.R
import com.panch.mvvmstarterapp.base.BaseFragmentWithDI
import com.panch.mvvmstarterapp.data.apiBaseUrl
import com.panch.mvvmstarterapp.data.rest.PhotoModel
import com.panch.mvvmstarterapp.ui.main.MainActivity
import com.panch.mvvmstarterapp.ui.renderers.PhotoRenderer
import com.panch.mvvmstarterapp.util.hide
import com.panch.mvvmstarterapp.util.show
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.layout_data_info.*
import javax.inject.Inject

class DetailFragment : BaseFragmentWithDI() {
    override val layoutId: Int = R.layout.fragment_detail

    @Inject
    lateinit var mainActivity: MainActivity

    private val selectedPhotoObserver = Observer<PhotoModel> {
        progressBar.show()
        textViewNoData.hide()

        Glide.with(context!!)
            .load("${apiBaseUrl}720/1080/?image=${it.id}")
            .addListener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    progressBar.hide()
                    textViewNoData.show()
                    return true
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    progressBar.hide()
                    return false
                }
            })
            .apply(RequestOptions())
            .into(imageViewFullscreen)
    }

    override fun onCreated() {
        mainActivity.photoDetailViewModel.selectedPhoto.observe(this, selectedPhotoObserver)
    }

    companion object {
        private var instance: DetailFragment? = null
        fun newInstance(): DetailFragment {
            if (instance == null) {
                instance = DetailFragment()
            }
            return instance!!
        }
    }
}