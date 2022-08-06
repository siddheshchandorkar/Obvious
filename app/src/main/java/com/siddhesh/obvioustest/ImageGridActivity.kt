package com.siddhesh.obvioustest

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.siddhesh.obvioustest.databinding.ActivityMainBinding

class ImageGridActivity : AppCompatActivity() {
    private lateinit var imageGridActivityViewModel: ImageGridActivityViewModel
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        imageGridActivityViewModel = ImageGridActivityViewModel()
        binding.vm = imageGridActivityViewModel
        binding.lifecycleOwner = this
    }
}