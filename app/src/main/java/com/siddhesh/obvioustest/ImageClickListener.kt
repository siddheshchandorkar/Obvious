package com.siddhesh.obvioustest

import com.siddhesh.commons.models.ImageDetailsModel

/*
* Used to handle image clicks
*/
interface ImageClickListener {
    fun onImageClick(imageDetailsModel: ImageDetailsModel)
}