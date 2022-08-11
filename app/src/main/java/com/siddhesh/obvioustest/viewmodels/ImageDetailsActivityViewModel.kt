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
class ImageDetailsActivityViewModel(private val imageDetailsModel: ImageDetailsModel?) : ViewModel() {
    var hdUrl: ObservableField<String> = ObservableField<String>(getImageUrl())
    var title: ObservableField<String> = ObservableField<String>(getImageTitle())
    var date: ObservableField<String> =
        ObservableField<String>(AppUtils.getFormattedDate(getImageDate()))
    var explanation: ObservableField<String> = ObservableField<String>(getImageExplanation())
    val errorVisible = ObservableField(false)
    var errorCallBack: MutableLiveData<RequestListener<Drawable>> = MutableLiveData(getCallBack())

    init {
        reset()
    }

    private fun reset() {
        errorVisible.set(false)
        errorCallBack.value = (null)
        errorCallBack.value = (getCallBack())
        hdUrl.set(getImageUrl())
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

    private fun getImageUrl(): String {
        return try {
            imageDetailsModel?.let {
                it.hdURL?.let { url ->
                    return url
                } ?: ""
            } ?: ""
        } catch (e: Exception) {
            ""
        }
    }

    private fun getImageTitle(): String {
        return try {
            imageDetailsModel?.let {
                it.title?.let { url ->
                    return url
                } ?: ""
            } ?: ""
        } catch (e: Exception) {
            ""
        }
    }

    private fun getImageDate(): String {
        return try {
            imageDetailsModel?.let {
                it.date?.let { url ->
                    return url
                } ?: ""
            } ?: ""
        } catch (e: Exception) {
            ""
        }
    }

    private fun getImageExplanation(): String {
        return try {
            imageDetailsModel?.let {
                it.explanation?.let { url ->
                    return url
                } ?: ""
            } ?: ""
        } catch (e: Exception) {
            ""
        }
    }


}