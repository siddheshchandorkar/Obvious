package com.siddhesh.obvioustest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
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