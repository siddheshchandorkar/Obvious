package com.siddhesh.obvioustest.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.siddhesh.commons.models.ImageDetailsModel


class ImageDetailsActivityViewModel(val imageDetailsModel: ImageDetailsModel) : ViewModel() {
    val hdUrl = ObservableField(imageDetailsModel.hdURL)
    val title = ObservableField(imageDetailsModel.title)
    val date = ObservableField(imageDetailsModel.date)
    val explanation = ObservableField(imageDetailsModel.explanation)
}