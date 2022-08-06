package com.siddhesh.obvioustest

import com.siddhesh.commons.models.ImageDetailsModel

interface ImageClickListener {
    fun onImageClick(imageDetailsModel: ImageDetailsModel)
}