package com.siddhesh.obvioustest.viewmodels

import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.siddhesh.commons.models.ImageDetailsModel
import com.siddhesh.commons.utils.AppUtils
import com.siddhesh.obvioustest.ImageClickListener
import java.text.SimpleDateFormat
import java.util.*

class ImageItemViewModel(
    private val imageDetailsModel: ImageDetailsModel,
    val imageClickListener: ImageClickListener
) : ViewModel(), Comparable<ImageDetailsModel> {
    val randomBackgroundColor = ObservableField(AppUtils.getRandomColorCode())
    val imageUrl = ObservableField(imageDetailsModel.url)
    val title = ObservableField(imageDetailsModel.title)
    val date = (imageDetailsModel.getParsedDate())
        fun viewDetails(view: View) {
        imageClickListener.onImageClick(imageDetailsModel = imageDetailsModel)
    }

    override fun compareTo(other: ImageDetailsModel): Int {
        return imageDetailsModel.getParsedDate().compareTo(other.getParsedDate())
    }

}