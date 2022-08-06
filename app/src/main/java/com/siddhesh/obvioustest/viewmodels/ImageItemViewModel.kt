package com.siddhesh.obvioustest.viewmodels

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.siddhesh.commons.models.ImageDetailsModel
import com.siddhesh.commons.utils.AppUtils
import com.siddhesh.obvioustest.ImageClickListener
import com.siddhesh.obvioustest.ImageDetailsActivity

class ImageItemViewModel(private val imageDetailsModel: ImageDetailsModel, val imageClickListener: ImageClickListener) : ViewModel(){
    val randomBackgroundColor = ObservableField(AppUtils.getRandomColorCode())
    val imageUrl = ObservableField(imageDetailsModel.url)
    val title = ObservableField(imageDetailsModel.title)

    fun viewDetails(view: View) {
        imageClickListener.onImageClick(imageDetailsModel = imageDetailsModel)
    }

}