package com.siddhesh.obvioustest.viewmodels

import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.siddhesh.commons.models.ImageDetailsModel
import com.siddhesh.commons.utils.AppUtils

class ImageItemViewModel(imageDetailsModel: ImageDetailsModel) : ViewModel() {
    val randomBackgroundColor = ObservableField(AppUtils.getRandomColorCode())
    val imageUrl = ObservableField(imageDetailsModel.url)
    val title = ObservableField(imageDetailsModel.title)

    fun viewDetails(view:View){

    }

}