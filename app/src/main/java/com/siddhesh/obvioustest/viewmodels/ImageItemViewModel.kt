package com.siddhesh.obvioustest.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.siddhesh.commons.models.ImageDetailsModel
import com.siddhesh.obvioustest.listener.ImageClickListener
import java.util.*

class ImageItemViewModel(
    private val imageDetailsModel: ImageDetailsModel,
    private val imageClickListener: ImageClickListener
) : ViewModel() {
    val imageUrl = ObservableField(imageDetailsModel.url)
    val title = ObservableField(imageDetailsModel.title)
    val date:Date? = imageDetailsModel.getParsedDate()
    fun viewDetails() {
        imageClickListener.onImageClick(imageDetailsModel = imageDetailsModel)
    }
}