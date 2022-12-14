package com.siddhesh.obvioustest.ui

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.siddhesh.commons.models.ImageDetailsModel
import com.siddhesh.network.RetrofitRepository
import com.siddhesh.obvioustest.listener.ImageClickListener
import com.siddhesh.obvioustest.R
import com.siddhesh.obvioustest.databinding.ActivityImageListBinding
import com.siddhesh.obvioustest.viewmodels.ImageGridActivityViewModel
import com.siddhesh.obvioustest.viewmodels.ImageItemViewModel
import java.util.*
import kotlin.Comparator


class ImageGridActivity : AppCompatActivity(), ImageClickListener {
    private lateinit var viewModel: ImageGridActivityViewModel
    private lateinit var binding: ActivityImageListBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_image_list)
        viewModel = ImageGridActivityViewModel(application)
        binding.vm = viewModel
        binding.lifecycleOwner = this
        binding.rcvImage.adapter = viewModel.gridAdapter
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        binding.rcvImage.layoutManager = staggeredGridLayoutManager

        RetrofitRepository.instance.imageListLiveData.observe(this) { serverlist ->
            val list = ArrayList<ImageItemViewModel>()
            serverlist?.let { it ->
                it.forEach { imageDetails ->
                    list.add(ImageItemViewModel(imageDetails, this))
                }
                list.sortWith(compareBy { item-> item.date })
                viewModel.gridAdapter.setData(list)
            }?: run {
                viewModel.isError.value = true
            }
            viewModel.isApiLoading.value=false
        }
    }

    override fun onImageClick(imageDetailsModel: ImageDetailsModel) {
        val intent= Intent(this, ImageDetailsActivity::class.java)
        val options = ActivityOptions.makeSceneTransitionAnimation(this)
        intent.putExtra(ImageDetailsActivity.KEY_IMAGE_DETAILS, imageDetailsModel)
        startActivity(intent, options.toBundle())
    }
}