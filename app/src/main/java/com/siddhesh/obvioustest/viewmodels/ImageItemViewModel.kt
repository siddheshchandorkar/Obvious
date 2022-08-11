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
import com.siddhesh.obvioustest.listener.ImageClickListener
import java.util.*

class ImageItemViewModel(
    private val imageDetailsModel: ImageDetailsModel,
    private val imageClickListener: ImageClickListener
) : ViewModel() {
    val imageUrl = ObservableField("")
    val title = ObservableField(imageDetailsModel.title)
    val date: Date? = imageDetailsModel.getParsedDate()
    val errorVisible = ObservableField(false)
    var errorCallBack: MutableLiveData<RequestListener<Drawable>> = MutableLiveData(getCallBack())

    init {
        reset()
    }

    private fun reset() {
        errorVisible.set(false)
        errorCallBack.value = (null)
        errorCallBack.value = (getCallBack())
        imageUrl.set(imageDetailsModel.url)
    }

    fun viewDetails() {
        imageClickListener.onImageClick(imageDetailsModel = imageDetailsModel)
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