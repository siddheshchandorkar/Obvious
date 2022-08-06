package com.siddhesh.obvioustest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.flexbox.*
import com.siddhesh.network.RetrofitRepository
import com.siddhesh.obvioustest.databinding.ActivityImageListBinding
import com.siddhesh.obvioustest.viewmodels.ImageGridActivityViewModel
import com.siddhesh.obvioustest.viewmodels.ImageItemViewModel


class ImageGridActivity : AppCompatActivity() {
    private lateinit var viewModel: ImageGridActivityViewModel
    private lateinit var binding: ActivityImageListBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_image_list)
        viewModel = ImageGridActivityViewModel()
        binding.vm = viewModel
        binding.lifecycleOwner = this
        binding.rcvImage.adapter=viewModel.gridAdapter
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        binding.rcvImage.layoutManager = staggeredGridLayoutManager

        RetrofitRepository.instance.imageListLiveData.observe(this) { serverlist ->
            val list= ArrayList<ImageItemViewModel>()
            serverlist?.let {
                it.forEach { imageDetails->
                    list.add(ImageItemViewModel(imageDetails))
                }
                viewModel.gridAdapter.setData(list)
            }

        }
    }
}