package com.siddhesh.obvioustest.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.siddhesh.commons.models.ImageDetailsModel
import com.siddhesh.commons.utils.AppUtils


class ImageDetailsActivityViewModel(val imageDetailsModel: ImageDetailsModel) : ViewModel() {
    val hdUrl = ObservableField(imageDetailsModel.hdURL)
    val title = ObservableField(imageDetailsModel.title)
    val date = ObservableField(AppUtils.getFormattedDate(imageDetailsModel.date!!))
    val explanation = ObservableField(imageDetailsModel.explanation)
}