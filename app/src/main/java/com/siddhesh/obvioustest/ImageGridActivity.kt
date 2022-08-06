package com.siddhesh.obvioustest

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.siddhesh.obvioustest.databinding.ActivityImageListBinding
import com.siddhesh.obvioustest.viewmodels.ImageGridActivityViewModel

class ImageGridActivity : AppCompatActivity() {
    private lateinit var viewModel: ImageGridActivityViewModel
    private lateinit var binding: ActivityImageListBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_image_list)
        viewModel = ImageGridActivityViewModel()
        binding.vm = viewModel
        binding.lifecycleOwner = this
    }
}