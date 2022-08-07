package com.siddhesh.obvioustest.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.siddhesh.commons.models.ImageDetailsModel
import com.siddhesh.obvioustest.listener.ImageClickListener

class ImageItemViewModel(
    private val imageDetailsModel: ImageDetailsModel,
    private val imageClickListener: ImageClickListener
) : ViewModel(), Comparable<ImageDetailsModel> {
    val imageUrl = ObservableField(imageDetailsModel.url)
    val title = ObservableField(imageDetailsModel.title)
    val date = (imageDetailsModel.getParsedDate())
    fun viewDetails() {
        imageClickListener.onImageClick(imageDetailsModel = imageDetailsModel)
    }

    override fun compareTo(other: ImageDetailsModel): Int {
        return imageDetailsModel.getParsedDate().compareTo(other.getParsedDate())
    }

}