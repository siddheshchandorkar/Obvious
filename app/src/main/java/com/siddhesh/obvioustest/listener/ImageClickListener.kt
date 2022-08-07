package com.siddhesh.obvioustest.listener

import com.siddhesh.commons.models.ImageDetailsModel

/*
* Used to handle image clicks
*/
interface ImageClickListener {
    fun onImageClick(imageDetailsModel: ImageDetailsModel)
}