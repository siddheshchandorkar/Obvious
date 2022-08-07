package com.siddhesh.obvioustest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.siddhesh.commons.models.ImageDetailsModel
import com.siddhesh.obvioustest.R
import com.siddhesh.obvioustest.databinding.ActivityImageDetailsBinding
import com.siddhesh.obvioustest.viewmodels.ImageDetailsActivityViewModel

class ImageDetailsActivity : AppCompatActivity() {
    private lateinit var viewModel: ImageDetailsActivityViewModel
    private lateinit var binding: ActivityImageDetailsBinding
    private lateinit var imageDetailsModel: ImageDetailsModel

    companion object{
        const val KEY_IMAGE_DETAILS="image_details"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_image_details)
        val bundle=intent.extras

        bundle?.let {
            if(it.containsKey(KEY_IMAGE_DETAILS)){
                imageDetailsModel= it.getParcelable(KEY_IMAGE_DETAILS)!!
            }else{
                finish()
            }
        }
        viewModel = ImageDetailsActivityViewModel(imageDetailsModel)
        binding.vm = viewModel
        binding.lifecycleOwner = this
    }
}