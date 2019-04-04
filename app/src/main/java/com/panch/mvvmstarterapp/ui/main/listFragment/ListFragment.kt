package com.panch.mvvmstarterapp.ui.main.listFragment

import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.panch.mvvmstarterapp.R
import com.panch.mvvmstarterapp.base.BaseFragmentWithDI
import com.panch.mvvmstarterapp.data.rest.DataWrapper
import com.panch.mvvmstarterapp.data.rest.PhotoModel
import com.panch.mvvmstarterapp.data.viewModel.PhotoListViewModel
import com.panch.mvvmstarterapp.ui.main.MainActivity
import com.panch.mvvmstarterapp.ui.renderers.PhotoRenderer
import com.panch.mvvmstarterapp.util.hide
import com.panch.mvvmstarterapp.util.show
import com.pedrogomez.renderers.RVRendererAdapter
import com.pedrogomez.renderers.RendererBuilder
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.layout_data_info.*
import javax.inject.Inject


class ListFragment : BaseFragmentWithDI() {
    override val layoutId: Int = R.layout.fragment_list

    lateinit var adapter: RVRendererAdapter<PhotoModel>

    @Inject
    lateinit var mainActivity: MainActivity

    @Inject
    lateinit var photoListViewModel: PhotoListViewModel

    private val photoClickListener = object : PhotoRenderer.PhotoClickListener {
        override fun onClickPhoto(photoModel: PhotoModel, imageView: ImageView) {
            mainActivity.photoDetailViewModel.setSelectedPhoto(photoModel)
            mainActivity.replaceFragment(mainActivity.detailFragment)
        }
    }

    private val photosObserver = Observer<DataWrapper<List<PhotoModel>>> {
        if (it.loading && it.data.isNullOrEmpty()) {
            progressBar.show()
            return@Observer
        }
        if (it.data == null) {
            textViewNoData.show()
            return@Observer
        }
        adapter.diffUpdate(it.data)
        progressBar.hide()
        textViewNoData.hide()
    }

    override fun onCreated() {
        recyclerViewPhotoList.layoutManager = GridLayoutManager(context, 2) as RecyclerView.LayoutManager?
        adapter = RVRendererAdapter(RendererBuilder(PhotoRenderer(photoClickListener)))
        recyclerViewPhotoList.adapter = adapter

        photoListViewModel.photos.observe(this, photosObserver)
        photoListViewModel.loadPhotos()
    }

    companion object {
        private var instance: ListFragment? = null
        fun newInstance(): ListFragment {
            if (instance == null) {
                instance = ListFragment()
            }
            return instance!!
        }
    }
}