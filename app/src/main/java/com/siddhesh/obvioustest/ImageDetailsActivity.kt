package com.siddhesh.obvioustest

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.siddhesh.obvioustest.databinding.ActivityImageDetailsBinding
import com.siddhesh.obvioustest.viewmodels.ImageDetailsActivityViewModel

class ImageDetailsActivity : AppCompatActivity() {
    private lateinit var viewModel: ImageDetailsActivityViewModel
    private lateinit var binding: ActivityImageDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_image_details)
        viewModel = ImageDetailsActivityViewModel()
        binding.vm = viewModel
        binding.lifecycleOwner = this
    }
}