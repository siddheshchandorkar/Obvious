package com.siddhesh.obvioustest.viewmodels

import android.graphics.drawable.Drawable
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.siddhesh.commons.models.ImageDetailsModel
import com.siddhesh.commons.utils.AppUtils

/*
* Image Details Displayed
* */
class ImageDetailsActivityViewModel(val imageDetailsModel: ImageDetailsModel) : ViewModel() {
    val hdUrl = ObservableField(imageDetailsModel.hdURL)
    val title = ObservableField(imageDetailsModel.title)
    val date = ObservableField(AppUtils.getFormattedDate(imageDetailsModel.date!!))
    val explanation = ObservableField(imageDetailsModel.explanation)
    val errorVisible = ObservableField(false)
    var errorCallBack: MutableLiveData<RequestListener<Drawable>> = MutableLiveData(getCallBack())

    init {
        reset()
    }

    private fun reset() {
        errorVisible.set(false)
        errorCallBack.value = (null)
        errorCallBack.value = (getCallBack())
        hdUrl.set(imageDetailsModel.url)
    }


    fun onRetry() {
        reset()
    }

    private fun getCallBack(): RequestListener<Drawable> {
        return object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                errorVisible.set(true)
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                errorVisible.set(false)
                return false

            }

        }

    }

}